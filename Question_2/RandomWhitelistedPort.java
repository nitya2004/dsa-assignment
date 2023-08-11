package CourseWork.Question_2;
//2.b
import java.util.*;
public class RandomWhitelistedPort {
    private List<Integer> whitelistedPorts;
    /**
     * Initializes a new instance of RandomWhitelistedPort with a list of allowed ports,
     * excluding any blacklisted ports.
     * 
     * @param k The maximum number of ports to consider.
     * @param blacklisted_ports An array of ports to be excluded from the whitelist.
     */
    public RandomWhitelistedPort(int k, int[] blacklisted_ports) {
        whitelistedPorts = new ArrayList<>();

        // Generate the list of whitelisted ports
        for (int i = 0; i < k; i++) {
            whitelistedPorts.add(i);// Add ports up to k to the whitelist.
        }
        for (int port : blacklisted_ports) {
            whitelistedPorts.remove(Integer.valueOf(port));// Remove blacklisted ports from the whitelist.
        }
    }
     /**
     * Gets a random whitelisted port from the list of allowed ports.
     * 
     * @return A random whitelisted port.
     */
    public int get() {
        int randomIndex = (int) (Math.random() * whitelistedPorts.size());
        return whitelistedPorts.get(randomIndex);// Return the port at the random index.
    }

    public static void main(String[] args) {
        int k = 7;
        int[] blacklisted_ports = {2, 3, 5};
        RandomWhitelistedPort randomPort = new RandomWhitelistedPort(k, blacklisted_ports);
        // Display randomly selected whitelisted ports.
        System.out.println(randomPort.get()); // Output: Random whitelisted port between 0 and 6
        System.out.println(randomPort.get()); // Output: Random whitelisted port between 0 and 6
    }
}
