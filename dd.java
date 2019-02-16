// Author: Bertram Felgenhauer <int-e@gmx.de>
"use strict";

// greatest common divisor
function gcd(a, b)
{
    for (;;) {
        if (a == 0)
            return b;
        b %= a;
        if (b == 0)
            return a;
        a %= b;
    }
}

// manage rectangle tilings data
var Tilings = {}

// Load tilings data from given URL.
//
// @param url: URL to load from
Tilings.load = function(url)
{
    var request = new XMLHttpRequest();
    var parent = this;
    request.onload = function() {
        parent.parse(this.responseText);
    };
    request.overrideMimeType("text/plain");
    request.open("GET", url);
    request.send();
}

// (Partially) parse tiling data.
//
// @param text: data to parse
Tilings.parse = function(text)
{
    var lines = text.split("\n");
    if (lines[lines.length - 1] == "")
        lines.pop();

    this.size = [0];
    this.data = [null];

    for (var i in lines) {
        var l = lines[i].split(" -> ");
        if (l.length != 2) {
            if (i == 0)
                this.decompress(lines,1);
            return;
        }
        var w = +l[0].split(",")[0];
        var h = +l[0].split(",")[1];
        var l = l[1].split(" : ");
        if (w >= this.size.length) {
            this.size.push([0]);
            this.data.push([0]);
        }
        this.size[w].push(l[0]);

        l = l[1];
        var val = l.split(" ").pop();
        switch (l.slice(0,5)) {
        case "basic":
            this.data[w].push(["b", val.split(",").slice(0,-1)]);
            break;
        case "scale":
            this.data[w].push(["x", +val]);
            break;
        case "squar":
            this.data[w].push(["s"]);
            break;
        case "horiz":
            this.data[w].push(["h", +val]);
            break;
        case "verti":
            this.data[w].push(["v", +val]);
        }
    }

    this.ready = true;
    if (this.progress)
        this.progress()
    if (this.onload)
        this.onload()
}

// decode compressed table format
Tilings.decompress = function(lines, w)
{
    // decode base 26 number
    var num = function(s) {
        var r = 0;
        for (var i in s)
            r = r*26 + s.charCodeAt(i) - 0x61;
        return r;
    }

    var start = new Date().getTime();

    var i = 0;
    var n = num(lines[lines.length - 1].slice(0,2));
    var wi = 0, hi = 0, l;

    for ( ; w < n; w++) {
        var size = [0];
        var data = [null];
        for (var h = 1; h <= w; h++) {
            if (wi < w || wi == w && hi < h) {
                l = lines[i++];
                wi = num(l.slice(0,2));
                hi = num(l.slice(2,4));
            }
            if (wi == w && hi == h) {
                var s = [];
                for (var j = 4; j < l.length; j += 3) {
                    var k = num(l.slice(j,j+1));
                    var sz = num(l.slice(j+1,j+3));
                    s.push(k + ":" + sz);
                }
                size.push(s.length);
                data.push(["b", s]);
            } else if (w == h) {
                size.push(1);
                data.push(["s"]);
            } else if (gcd(w,h) > 1) {
                var d = gcd(w,h)
                size.push(this.size[w/d][h/d]);
                data.push(["x", d]);
            } else {
                var b = w+1;
                var d;
                for (var s = 1; s <= w/2; s++) {
                    var sz = this.squares(s, h) + this.squares(w-s, h);
                    if (sz < b) {
                        d = ["h", s];
                        b = sz;
                    }
                }
                for (var s = 1; s <= h/2; s++) {
                    var sz = size[s] + size[h-s];
                    if (sz < b) {
                        d = ["v", s];
                        b = sz;
                    }
                }
                size.push(b);
                data.push(d);
            }
        }
        this.size.push(size);
        this.data.push(data);

        // processing takes a while - so process in chunks
        if (new Date().getTime() - start > 100) {
            // TODO: add some sort of progress indicator?
            var parent = this;
            lines = lines.slice(i-1);
            setTimeout(function(){
                parent.decompress(lines, w+1);
            }, 10);
            if (this.progress)
                this.progress()
            return;
        }
    }

    this.ready = true;
    if (this.progress)
        this.progress()
    if (this.onload)
        this.onload()
}

// Produce a tiling of a w x h rectangle into squares.
//
// @param w: width of rectangle
// @param h: height of rectangle
// @param scale: defaults to 1; scale factor to apply to produces squares
// @param x0, y0: default to 0; offset to apply to produced squares
// @return: array of triples [x, y, size] describing one square each
Tilings.reconstruct = function(w, h, scale, x0, y0)
{
    if (x0 === undefined) x0 = 0;
    if (y0 === undefined) y0 = 0;
    if (scale === undefined) scale = 1;

    if (w < h) {
        // w < h: get transposed solution
        var result = this.reconstruct(h, w, scale, y0, x0);
        for (var i in result) {
            result[i] = [result[i][1], result[i][0], result[i][2]];
        }
        return result;
    }

    // look up solution
    var l = this.data[w][h];
    if (l == undefined)
        return;
    switch (l[0]) {
    case "b":
        var squares = l[1];
        var peaks = [[0,w],[h,0]];
        var result = [];
        for (var i in squares) {
            var l = squares[i].split(":");
            var n = +l[0];
            var w = +l[1];
            var y = peaks[n-1][0];
            var x = peaks[n][1];
            result.push([x0 + x*scale, y0 + y*scale, w*scale]);
            var merge_l = peaks[n-1][1] == x+w;
            var merge_r = peaks[n][0] == y+w;
            peaks.splice(n - merge_l, merge_l + merge_r, [y + w, x + w])
        }
        return result;
    case "x":
        return this.reconstruct(w/l[1], h/l[1], scale*l[1], x0, y0);
    case "s":
        return [[x0, y0, w*scale]];
    case "h":
        return this.reconstruct(l[1], h, scale, x0, y0)
            .concat(this.reconstruct(w - l[1], h, scale, x0 + scale*l[1], y0));
    case "v":
        return this.reconstruct(w, l[1], scale, x0, y0)
            .concat(this.reconstruct(w, h - l[1], scale, x0, y0 + scale*l[1]));
    }
}

// Draw tiled rectangle to the given HTML canvas. The rectangle is centered
// within the canvas.
//
// @param canvas: canvas element to draw to
// @param w: width of rectangle
// @param h: height of rectangle
// @param scale: optional scale factor for rectangle; by default, try to use
//   as much of the canvas area as possilbe with an integral scale factor.
Tilings.draw = function(canvas, w, h, scale)
{
    if (scale === undefined) {
        scale = Math.min((canvas.width - 1)/w, (canvas.height - 1)/h);
        scale = Math.max(1, Math.floor(scale));
    }

    var ctx = canvas.getContext("2d");
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    var squares = this.reconstruct(
        w, h, scale,
        Math.round((canvas.width - 1 - w*scale)/2),
        Math.round((canvas.height - 1 - h*scale)/2));

    for (var i in squares) {
        var sq = squares[i];
        ctx.fillStyle = "hsl(" + 222.5*sq[2]/scale + ",100%,90%)";
        ctx.fillRect(sq[0] + 1, sq[1] + 1, sq[2] - 1, sq[2] - 1);
        ctx.strokeRect(sq[0] + .5, sq[1] + .5, sq[2], sq[2]);
        if (sq[2] >= 10) {
            ctx.font = .5*sq[2] + "px sans serif";
            ctx.fillStyle = "black";
            ctx.textAlign = "center";
            ctx.textBaseLine = "middle";
            ctx.fillText(sq[2]/scale, sq[0] + .5*sq[2], sq[1] + .65*sq[2]);
        }
    }
}

// Find number of squares of tiled rectangle.
//
// @param w: width of rectangle
// @param h: height of rectangle
// @return: number of squares
Tilings.squares = function(w, h)
{
    if (w < h)
        return this.size[h][w];
    return this.size[w][h];
}

// Produce Bouwkamp code for tiled rectangle.
//
// @param w: width of rectangle
// @param h: height of rectangle
// @return: Bouwkamp code for rectangle.
Tilings.code = function(w, h)
{
    var squares = this.reconstruct(w, h);

    if (squares === undefined)
        return "<invalid input>";

    squares.sort(
        function(a, b) {
            return (a[1] - b[1]) || (a[0] - b[0]);
        });

    var y = 0;
    var result = squares.length + " " + w + " " + h + " (";

    for (var i in squares) {
        var sq = squares[i];
        if (sq[1] != y) {
            y = sq[1];
            result += ")(";
        } else if (i>0) {
            result += ",";
        }
        result += sq[2];
    }
    return result + ")";
}

// UI

// Initialization.
//
// @param url: URL for tilings data
function load(url)
{
    Tilings.progress = function() {
        update();
    }
    Tilings.load(url)

    window.onhashchange = function() {
        if (window.location.hash) {
            var h = window.location.hash.slice(1).split(",");
            update(+h[0], +h[1]);
        }
    }
    window.onhashchange();
}

// Make an internal link to some tiling.
function link(w, h)
{
    var result = document.createElement("a");
    result.href = "#" + w + "," + h;
    result.appendChild(document.createTextNode(h + "\u00D7" + w));
    return result;
}

// Update to a new rectangle size
function update(w, h)
{
    if (w === undefined)
        w = Math.round(document.getElementById("rect_w").value);
    if (h === undefined)
        h = Math.round(document.getElementById("rect_h").value);
    w = isNaN(w) ? 13 : w;
    h = isNaN(h) ? 11 : h;
    if (w < 1)
        w = 1;
    if (Tilings.ready && w >= Tilings.size.length)
        w = Tilings.size.length - 1;
    if (h < 1)
        h = 1;
    if (Tilings.ready && h >= Tilings.size.length)
        h = Tilings.size.length - 1;

    document.getElementById("rect_w").value = w;
    document.getElementById("rect_h").value = h;

    history.replaceState(null, document.title, "#" + w + "," + h);

    if (!Tilings.size || Tilings.size.length < (w > h ? w : h))
        return;

    var e = document.getElementById("rect_data");
    while (e.hasChildNodes())
        e.removeChild(e.firstChild);
    if (w < h) {
        e.appendChild(document.createTextNode("transpose "));
        e.appendChild(link(h,w));
    } else {
        var data = Tilings.data[w][h];
        if (data === undefined) {
            e.appendChild(document.createTextNode("<invalid input>"));
        } else {
            switch (data[0]) {
            case "b":
                e.appendChild(document.createTextNode(
                    "basic solution (" + data[1] + ")"));
                break;
            case "x":
                e.appendChild(document.createTextNode("scale "));
                e.appendChild(link(w/data[1], h/data[1]));
                e.appendChild(document.createTextNode(" by " + data[1]));
                break;
            case "s":
                e.appendChild(document.createTextNode("square"));
                break;
            case "h":
                e.appendChild(document.createTextNode("join "));
                e.appendChild(link(data[1], h));
                e.appendChild(document.createTextNode(" and "));
                e.appendChild(link(w - data[1], h));
                e.appendChild(document.createTextNode(" horizontally"));
                break;
            case "v":
                e.appendChild(document.createTextNode("join "));
                e.appendChild(link(w, data[1]));
                e.appendChild(document.createTextNode(" and "));
                e.appendChild(link(w, h - data[1]));
                e.appendChild(document.createTextNode(" vertically"));
                break;
            }
        }
    }

    document.getElementById("rect_squares").firstChild.nodeValue =
        Tilings.squares(w, h);

    document.getElementById("rect_code").firstChild.nodeValue =
        Tilings.code(w, h);

    Tilings.draw(document.getElementById("canvas"), w, h);
}

// Increment the value of an input element
function inc(id, min, max)
{
    var e = document.getElementById(id);
    if (+e.value > max - 1)
        return;
    e.value++;
    update();
}

// Decrement the value of an input element
function dec(id, min, max)
{
    var e = document.getElementById(id);
    if (+e.value < min + 1)
        return;
    e.value--;
    update();
}

function inc_sz(id)
{
    inc(id, 1, Tilings.size.length - 1)
}

function dec_sz(id)
{
    dec(id, 1, Tilings.size.length - 1)
}
