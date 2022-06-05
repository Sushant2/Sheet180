//GFG - N Meetings in a room
//Greedy Approach
//time comp - O(n) + O(n*logn) + O(n) = O(n*logn)
//space comp - O(n)

class Solution {
    // custom class for storing start time, end time, & position of meeting
    public static class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    // comparator function which can compare the ending time of the meetings
    // sort the list
    public static class meetingComparator implements Comparator<meeting> {
        @Override
        public int compare(meeting m1, meeting m2) {
            if (m1.end < m2.end)
                return -1;
            else if (m1.end > m2.end)
                return 1;
            // if above both conditions not satisfied, means their finishing time is equal
            // we'll sort them acc. to their "pos"
            else if (m1.pos < m2.pos)
                return -1;
            return 1;
        }
    }

    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        // ArrayList<Integer> ans = new ArrayList<>();
        // ans.add(meet.get(0).pos);
        int ans = 1;
        int currEnd = meet.get(0).end;
        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > currEnd) {
                currEnd = meet.get(i).end;
                // ans.add(meet.get(i).pos);
                ans++;
            }
        }
        return ans;
    }
}
