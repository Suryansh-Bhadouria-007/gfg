package mock1.intersectionOfDisjointSets;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

class Solution {
    public static void main(String[] args) {
        Interval A[] = {new Interval(3, 10)};
        Interval B[] = {new Interval(5, 10)};

        Interval[] x = intervalIntersection(A, B);
        for (Interval i : x) {
            System.out.println(i);
        }
    }

    static class Result {
        boolean doesOverlap;
        String liesBefore;

        public Result(boolean doesOverlap, String liesBefore) {
            this.doesOverlap = doesOverlap;
            this.liesBefore = liesBefore;
        }
    }



    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> result = new ArrayList<>();
        int lenA = A.length;
        int lenB = B.length;
        int a = 0, b = 0;
        while (a < lenA && b < lenB) {
            Interval intervalA = A[a];
            Interval intervalB = B[b];
            Result overlap = doesOverlap(intervalA, intervalB);
            if (overlap.doesOverlap) {
                String intervalWhichLiesBefore = overlap.liesBefore;
                Interval res;
                switch (intervalWhichLiesBefore) {
                    case "A":
                        a++;
                        res = new Interval(intervalB.start, intervalA.end);
                        result.add(res);
                        break;
                    case "B":
                        b++;
                        res = new Interval(intervalA.start, intervalB.end);
                        result.add(res);
                        break;
                    case "C":
                        a++;
                        b++;
                        res = new Interval(intervalA.start, intervalA.end);
                        result.add(res);
                        break;
                    case "":
                        break;
                }
            } else {
                String whichLiesBeforeNoOverlap = overlap.liesBefore;
                switch (whichLiesBeforeNoOverlap) {
                    case "A":
                        a++;
                        break;
                    case "B":
                        b++;
                        break;
                    case "":
                        break;
                }
            }
        }
        Interval res[] = new Interval[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private static Result doesOverlap(Interval A, Interval B) {
        if (B.start > A.start && B.start < A.end)
            return new Result(true, "A");
        if (B.start >= A.start && B.end < A.end)
            return new Result(true, "B");
        if (A.start > B.start && A.start < B.end)
            return new Result(true, "B");
        if (A.start >= B.start && A.end < B.end)
            return new Result(true, "A");
        if (A.start == B.start && A.end == B.end)
            return new Result(true, "C");
        if (A.start == B.end || A.end == B.start) {
            if (A.start == B.end)
                return new Result(true, "B");
            else if (A.end == B.start)
                return new Result(true, "A");
        }
        if (A.start > B.end)
            return new Result(false, "B");
        if (A.end < B.start)
            return new Result(false, "A");
        return new Result(false, "");
    }
}