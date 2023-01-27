import './Tree.css';
import d3 from "d3";

function Tree() {


    var D3UTILITY = D3UTILITY || {};
    var DYNAMICTREE = DYNAMICTREE || {};

    var tree, root, svg, i, diagonal, duration;

    function click(d)
    {
        DYNAMICTREE.updateJson(d);
    }

    D3UTILITY.drawTree = function () {
        var margin = {top: 20, right: 120, bottom: 20, left: 120},
            width = 960 - margin.right - margin.left,
            height = 800 - margin.top - margin.bottom;

        i = 0;
        duration = 750;

        tree = d3.layout.tree()
            .size([height, width]);

        diagonal = d3.svg.diagonal()
            .projection(function (d) {
                return [d.y, d.x];
            });

        svg = d3.select("body").append("svg")
            .attr("width", width + margin.right + margin.left)
            .attr("height", height + margin.top + margin.bottom)
            .append("g")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
        root = DYNAMICTREE.treeJson;
        root.x0 = height / 2;
        root.y0 = 0;

        function collapse(d) {
            if (d.children) {
                d._children = d.children;
                d._children.forEach(collapse);
                d.children = null;
            }
        }

        collapse(root);
        D3UTILITY.update(root);

        //d3.select(self.frameElement).style("height", "800px");
    };


    D3UTILITY.update = function (source) {
        var nodes = tree.nodes(root).reverse(),
            links = tree.links(nodes);

        nodes.forEach(function (d) {
            d.y = d.depth * 180;
        });

        var node = svg.selectAll("g.node")
            .data(nodes, function (d) {
                return d.id || (d.id = ++i);
            });

        var nodeEnter = node.enter().append("g")
            .attr("class", "node")
            .attr("transform", function (d) {
                return "translate(" + source.y0 + "," + source.x0 + ")";
            })
            .on("click", click);

        nodeEnter.append("circle")
            .attr("r", 1e-6)
            .style("fill", function (d) {
                return d._children ? "lightsteelblue" : "#fff";
            });

        nodeEnter.append("text")
            .attr("x", function (d) {
                return d.children || d._children ? -10 : 10;
            })
            .attr("dy", ".35em")
            .attr("text-anchor", function (d) {
                return d.children || d._children ? "end" : "start";
            })
            .text(function (d) {
                return d.name;
            })
            .style("fill-opacity", 1e-6);

        var nodeUpdate = node.transition()
            .duration(duration)
            .attr("transform", function (d) {
                return "translate(" + d.y + "," + d.x + ")";
            });

        nodeUpdate.select("circle")
            .attr("r", 4.5)
            .style("fill", function (d) {
                return d._children ? "lightsteelblue" : "#fff";
            });

        nodeUpdate.select("text")
            .style("fill-opacity", 1);

        var nodeExit = node.exit().transition()
            .duration(duration)
            .attr("transform", function (d) {
                return "translate(" + source.y + "," + source.x + ")";
            })
            .remove();

        nodeExit.select("circle")
            .attr("r", 1e-6);

        nodeExit.select("text")
            .style("fill-opacity", 1e-6);

        var link = svg.selectAll("path.link")
            .data(links, function (d) {
                return d.target.id;
            });

        link.enter().insert("path", "g")
            .attr("class", "link")
            .attr("d", function (d) {
                var o = {x: source.x0, y: source.y0};
                return diagonal({source: o, target: o});
            });

        link.transition()
            .duration(duration)
            .attr("d", diagonal);

        link.exit().transition()
            .duration(duration)
            .attr("d", function (d) {
                var o = {x: source.x, y: source.y};
                return diagonal({source: o, target: o});
            })
            .remove();

        nodes.forEach(function (d) {
            d.x0 = d.x;
            d.y0 = d.y;
        });
    };

    var initialJson = {
        "name": "A",
        "children": [{
            "name": "B",
        },
            {
                "name": "C",
            },
            {
                "name": "D",
            }],
        "type": "Incident"
    };

    DYNAMICTREE.treeJson = initialJson;

    DYNAMICTREE.getNewData = function(node) {
        return [{
            name: "E",
        }, {
            name: "F",
        }];
    };

    DYNAMICTREE.updateJson = function(node) {
        console.log("node id", node.id);


        if (node._children) {
            node._children.forEach(function(childNode) {
                var associatedItems = DYNAMICTREE.getNewData(childNode);
                childNode._children = associatedItems;
            });
        }


        if (node.children) {
            node._children = node.children;
            node.children = null;
        }

        else {
            node.children = node._children;
            node._children = null;
        }


        D3UTILITY.update(node);
    };
    return (
        <div>
            <button onClick={D3UTILITY.drawTree()}>Draw Tree</button>
        </div>
    );
}

export default Tree;