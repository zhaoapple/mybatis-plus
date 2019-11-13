package com.info33.mybatisplus.calculate02;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Test04 {
    public static void main(String[] args) {


//[
//        {"lat":32.33414,"lng":118.84941},
//        {"lat":32.22326,"lng":118.84941},
//        {"lat":32.22093,"lng":119.04991},
//        {"lat":32.35154,"lng":119.02382},
//        {"lat":32.3527,"lng":119.02313}
//]
        List<RegionPath> pathList = new ArrayList();
        pathList.add(new RegionPath(118,32));
        pathList.add(new RegionPath(118,35));
        pathList.add(new RegionPath(119,32));
        pathList.add(new RegionPath(119,35));
        double longitudeCur = 118.62;
        double latitudeCur = 32.47;
        boolean b = IsInRegion(longitudeCur, latitudeCur, pathList);
        System.out.println("b = " + b);
    }

    /// <summary>
    /// 判断经纬度是否在范围类
    /// </summary>
    /// <param name="longitudeCur">经度</param>
    /// <param name="latitudeCur">纬度</param>
    /// <param name="pathList"></param>
    /// <returns></returns>
    public static boolean IsInRegion(double longitudeCur, double latitudeCur, List<RegionPath> pathList)
    {
        if (pathList.size() < 3)//点小于3无法构成多边形
        {
            return false;
        }
        int iSum = 0;
        int pathCount = pathList.size();
        double longStart = 0, latiStart = 0, longEnd = 0, latiEnd = 0;
        double dLong = 0;
        for (int i = 0; i < pathCount; i++)
        {
            int nextIndex = i + 1;
            if (i == pathCount - 1)
            {
                nextIndex = 0;
            }
            longStart = pathList.get(i).getLongitude();
            latiStart = pathList.get(i).getLatitude();
            longEnd = pathList.get(nextIndex).getLongitude();
            latiEnd = pathList.get(nextIndex).getLongitude();

//            longStart = pathList[i].Longitude;
//            latiStart = pathList[i].Latitude;
//            longEnd = pathList[nextIndex].Longitude;
//            latiEnd = pathList[nextIndex].Latitude;

            //判断纬度即Y坐标是否在2点的Y坐标内，只有在其内水平线才会相交
            if ((latitudeCur >= latiStart && latitudeCur < latiEnd) ||
                    (latitudeCur >= latiEnd && latitudeCur < latiStart))
            {
                if (Math.abs(latiStart-latiEnd)>0)
                {
                    dLong = longStart - ((longStart - longEnd) * (latiStart - latitudeCur)) / (latiStart - latiEnd);
                    if (dLong < longitudeCur)
                    {
                        iSum++;
                    }
                }
            }
        }

        if ((iSum % 2) != 0)
        {
            return true;
        }
        return false;
    }
}
@Data
class RegionPath{
    private double Longitude;
    private double Latitude;

    public RegionPath(double longitude, double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }
}