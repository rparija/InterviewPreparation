package wayfair;

import java.util.Arrays;

/*Write a function that classifies IP addresses into predefined buckets based on their range.
The function should accept a list of IP address strings and return a corresponding list of integers
representing the bucket each IP address belongs to. The buckets are defined by specific IP address ranges.
If an IP address does not fall into any of the defined buckets or is not a valid IP address,
the function should return -1 for that IP address.

The IP address ranges for the buckets are as follows:

Bucket 0: 0.0.0.0 - 127.255.255.255
Bucket 1: 128.0.0.0 - 191.255.255.255
Bucket 2: 192.0.0.0 - 223.255.255.255
Bucket 3: 224.0.0.0 - 239.255.255.255
Bucket 4: 240.0.0.0 - 255.255.255.255
*/
public class IpAddressBucketFind {

    public static void main(String[] args) {
        String[] ips1 = {"192.168.1.1", "256.1.1.1"};
        int [] bucketArray=findIpBucket(ips1);
        System.out.println(Arrays.toString(bucketArray));

        String[] ips2 = {
                /*"0.0.0.0", "127.255.255.255", // Bucket 0
                "128.0.0.0", "191.255.255.255", // Bucket 1
                "192.0.0.0", "223.255.255.255", // Bucket 2
                "224.0.0.0", "239.255.255.255", // Bucket 3
                "240.0.0.0", "255.255.255.255", // Bucket 4
               */ "invalid-ip", "10.0.0.1", "1.2.3", "1.2.3.4.5", "192.168.1.256", "abc.def.ghi.jkl"
        };
        int[] result2 = findIpBucket(ips2);
        System.out.print("Input: [\"0.0.0.0\", ..., \"abc.def.ghi.jkl\"]\nOutput: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        // Expected: [0, 0, 1, 1, 2, 2, 3, 3, 4, 4, -1, 0, -1, -1, -1, -1]
    }

    private static int [] findIpBucket(String[] ips) {

        int [] bucketArray= new int[ips.length];
        int i=0;
        for(String s:ips)
        {
            String [] arr=s.split("\\.");
            if(!(arr.length ==4)) {
                bucketArray[i] = -1;
                i++;
                continue;
            }
            try {
                int firstIp = Integer.parseInt(arr[0]);
                bucketArray[i]=findBucket(firstIp);
                i++;
            }catch (NumberFormatException ex)
            {
                bucketArray[i] = -1;
                i++;
                continue;
            }
        }
        return bucketArray;
    }

    public static int findBucket(int octNet)
    {
        if(octNet>=0 && octNet<128)
        {
            return 0;
        }
        else if(octNet>=128 && octNet<192)
        {
            return 1;
        }
        else if(octNet>=192 && octNet<224)
        {
            return 2;
        }
        else if(octNet>=224 && octNet<240)
        {
            return 3;
        }
        else if(octNet>=240 && octNet<256)
        {
            return 4;
        }
        return -1;
    }
}
