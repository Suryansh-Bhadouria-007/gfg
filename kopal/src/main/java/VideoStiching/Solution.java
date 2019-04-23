package VideoStiching;

import java.util.*;

class Clip {
    int start;
    int end;

    public Clip(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clip clip = (Clip) o;
        return start == clip.start &&
                end == clip.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

public class Solution {
    public static void main(String[] args) {
        int clips[][] = {{8, 10}, {17, 39}, {18, 19}, {8, 16}, {13, 35}, {33, 39}, {11, 19}, {18, 35}};
        System.out.println(videoStitching(clips, 20));
    }

    public static int videoStitching(int[][] clips, int T) {
        int count = 0;
        Set<Clip> clipToLengthMap = new HashSet<>();
        for (int i = 0; i < clips.length; i++) {
            clipToLengthMap.add(new Clip(clips[i][0], clips[i][1]));
        }
        int timeProcessed = 0;
        Clip nextClip = null;
        while (clipToLengthMap.size() > 0 && timeProcessed < T) {
            nextClip = getNextClip(clipToLengthMap, nextClip);
            if (nextClip == null)
                break;
            timeProcessed = nextClip.end;
            count++;
        }
        if (timeProcessed < T)
            return -1;

        return count;
    }


    private static Clip getNextClip(Set<Clip> clipSet, Clip currentClip) {
        Clip clipWithMaxEndTime = null;
        int end;
        if (currentClip == null) {
            end = 0;
        } else {
            end = currentClip.end;
        }
        Set<Clip> eligibleClips = new HashSet<>();
        for (Clip clip : clipSet) {
            if (clip.start <= end && clip.end > end) {
                eligibleClips.add(clip);
            }
        }
        int maxLimit = Integer.MIN_VALUE;
        for (Clip clip : eligibleClips) {
            if (clip.end > maxLimit) {
                clipWithMaxEndTime = clip;
                maxLimit = clip.end;
            }
        }
        clipSet.remove(clipWithMaxEndTime);
        return clipWithMaxEndTime;
    }
}
