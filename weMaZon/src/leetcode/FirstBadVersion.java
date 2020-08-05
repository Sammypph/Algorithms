package leetcode;

import java.util.TreeSet;

/**
 * Created by oakinrele on May, 2020
 */
public class FirstBadVersion {
    static TreeSet<Integer> badVersions = new TreeSet<>();
    static TreeSet<Integer> goodVersions = new TreeSet<>();
    static TreeSet<Integer> terribleVersions = new TreeSet<>();

    public static int firstBadVersion(int n) {

//        if (!versions.isEmpty()) {
//            if (n >= versions.first()) {
//                return versions.first();
//            }
//        } else if (isBadVersion(n)) {
//            versions.add(n);
//        }


        //Pass 5
        //If it fails try the previous one

        int currentBadNumber;
        int firstBadVersion = getFirstBadVersion(n);
        int lastGoodVersion = getLastGoodVersion(n);


        return firstBadVersion - lastGoodVersion > 1? lastGoodVersion + 1 : firstBadVersion;

    }


    public static int badVersion(int n) {
        //Pass 5
        //If it fails try the previous one

        int currentBadNumber;
        int firstBadVersion = getFirstBadVersion(n);
        int lastGoodVersion = getLastGoodVersion(n);


        return firstBadVersion - lastGoodVersion > 1? lastGoodVersion + 1 : firstBadVersion;

    }



    static int getBadVersion(int n)
    {
        if(!terribleVersions.isEmpty())
        {
            if(terribleVersions.first() <= n)
            {
                return terribleVersions.first();
            }
        }


        while(isBadVersion(n))
        {
            terribleVersions.add(n);
            n = n-1;
        }

        return n + 1;
    }


    static int getVersionBad(int n)
    {
        //5

        if(isBadVersion(n/2))
        {
            while(isBadVersion(n))
            {
                terribleVersions.add(n);
                n = n-1;
            }
        }

        else
        {
            n = n/2;
            while(!isBadVersion(n))
            {
                n++;
            }
        }

        return n + 1;
    }




    static int getFirstBadVersion(int n)
    {
        if (!badVersions.isEmpty())
        {
            if (n >= badVersions.first())
            {
                return badVersions.first();
            }
        }

        else if (isBadVersion(n))
        {
            badVersions.add(n);
        }

        return badVersions.first();
    }


    static int getLastGoodVersion(int n)
    {
        if (!goodVersions.isEmpty())
        {
                return goodVersions.last();
        }

        else if (!isBadVersion(n))
        {
            goodVersions.add(n);
        }

        return goodVersions.last() == null? 0 : goodVersions.last();
    }


    //Mocked Response
    static boolean isBadVersion(int x)
    {
        return true;
    }


    public static void main(String [] args)
    {

    }
}





///* The isBadVersion API is defined in the parent class VersionControl.
//      boolean isBadVersion(int version); */
//
//public class Solution extends VersionControl {
//    TreeSet<Integer> terribleVersions = new TreeSet<>();
//    public int firstBadVersion(int n) {
//        int firstBadVersion = getFirstBadVersion(n);
//
//        return firstBadVersion;
//
//    }
//
//
//    public int getFirstBadVersion(int n)
//    {
//        if(!terribleVersions.isEmpty())
//        {
//            if(n >= terribleVersions.first())
//            {
//                return terribleVersions.first();
//            }
//        }
//
//
//        while(isBadVersion(n))
//        {
//            terribleVersions.add(n);
//            n = n-1;
//        }
//
//        return n+1;
//    }
//
//}


