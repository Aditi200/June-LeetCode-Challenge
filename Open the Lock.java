   public int openLock(String[] deadends, String target) {
        // 9 means -1
        final int[] DIRS = new int[] {1,9};
        boolean[] visited = new boolean[10000];
        for (String d : deadends)
            visited[Integer.parseInt(d)] = true;
        // if "0000" is deadend
        if (visited[0])
            return -1;
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int turns = 0, iTarget = Integer.parseInt(target);
        while (! queue.isEmpty()) {
            int nodes = queue.size();
            while(nodes-- > 0) {
                int f = queue.poll();
                if (f == iTarget)
                    return turns;
                for (int i = 0, ff = f, mult = 1; i < 4; i++, mult *= 10, ff /= 10) {
                    int digit = ff % 10, codeNoDigit = f - digit * mult;
                    for (int d : DIRS) {
                        int newCode = codeNoDigit + ((digit + d) % 10) * mult;
                        if (! visited[newCode]) {
                            visited[newCode] = true;
                            queue.offer(newCode);
                        }
                    }
                }
            }
            turns++;
        }
        return -1;
    }