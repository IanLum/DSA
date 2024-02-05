class Graph<VertexType> {
    private var vertices: MutableSet<VertexType> = mutableSetOf()
    private var edges: MutableMap<VertexType, MutableSet<VertexType>> = mutableMapOf()

    /**
     * Add the vertex [v] to the graph
     * @param v the vertex to add
     * @return true if the vertex is successfully added, false if the vertex
     *   was already in the graph
     */
    fun addVertex(v: VertexType): Boolean {
        if (vertices.contains(v)) {
            return false
        }
        vertices.add(v)
        return true
    }

    /**
     * Add an edge between vertex [from] connecting to vertex [to]
     * @param from the vertex for the edge to originate from
     * @param to the vertex to connect the edge to
     * @return true if the edge is successfully added and false if the edge
     *     can't be added or already exists
     */
    fun addEdge(from: VertexType, to: VertexType): Boolean {
        if (!vertices.contains(from) || !vertices.contains(to)) {
            return false
        }
        edges[from]?.also { currentAdjacent ->
            if (currentAdjacent.contains(to)) {
                return false
            }
            currentAdjacent.add(to)
        } ?: run {
            edges[from] = mutableSetOf(to)
        }
        return true
    }

    /**
     * Perform breadth first search to see if a there is a path from [start] to [target]
     * @param start the vertex to start the search from
     * @param target the vertex to find a path to
     * @return true if there is a valid path, false if there isn't
     */
    fun breadthFirstSearch(start: VertexType, target: VertexType): Boolean {
        if (start !in vertices || target !in vertices) return false

        val seen: MutableSet<VertexType> = mutableSetOf()
        val priority: MyQueue<VertexType> = MyQueue()

        seen.add(start)
        priority.enqueue(start)

        while (!priority.isEmpty()) {
            val current = priority.dequeue()
            println(current)
            if (current == target) return true
            for (neighbor in edges[current] ?: emptySet()) {
                if (neighbor !in seen) {
                    seen.add(neighbor)
                    priority.enqueue(neighbor)
                }
            }
        }
        return false
    }

    /**
     * Clear all vertices and edges
     */
    fun clear() {
        vertices = mutableSetOf()
        edges = mutableMapOf()
    }
}