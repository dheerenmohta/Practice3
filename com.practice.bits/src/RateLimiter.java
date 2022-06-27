import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RateLimiter {

    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    private static HashMap<String, List<Integer>> hashmap;
    private static HashMap<String, Integer> timeMapping;

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        System.out.println(RateLimiter.isRatelimited(1, "login", "3/m", true));
        System.out.println(RateLimiter.isRatelimited(11, "login", "3/m", true));
        System.out.println(RateLimiter.isRatelimited(21, "login", "3/m", true));
        System.out.println(RateLimiter.isRatelimited(30, "login", "3/m", true));
        System.out.println(RateLimiter.isRatelimited( 65, "login", "3/m", true));

    }

    public RateLimiter () {
        hashmap = new HashMap<String, List<Integer>>();
        timeMapping = new HashMap<String, Integer>();
        timeMapping.put("s", 1);
        timeMapping.put("m", 60);
        timeMapping.put("h", 3600);
        timeMapping.put("d", 86400);
    }

    public static boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        if(rate == null || rate.length() == 0 || timestamp <= 0) {
            return false;
        }
        String[] splits = rate.split("/");
        int times = Integer.parseInt(splits[0]);
        int timelimit = timeMapping.get(splits[1]);

        hashmap.putIfAbsent(event, new ArrayList<Integer>());
        int startTime = timestamp - timelimit + 1;

        // count how many elements >= startTime;
        int count = countTimes(hashmap.get(event), startTime);

        boolean islimited = count >= times;
        if(increment && !islimited) {
            hashmap.get(event).add(timestamp);
        }
        return islimited;
    }

    private static int countTimes(List<Integer> list, int target) {
        if(list.size() == 0 || list.get(list.size() -1) < target) {
            return 0;
        }
        int start = 0; int end = list.size() - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(list.get(start) >= target) {
            return list.size() - start;
        } else {
            return list.size() - end;
        }
    }



}
