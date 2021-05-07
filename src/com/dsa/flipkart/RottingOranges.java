package com.dsa.flipkart;

// https://leetcode.com/problems/rotting-oranges/

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {
        int time = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<OrangeCell> queue=new LinkedList<>();
        int R=grid.length;
        int C=grid[0].length;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==2)
                    queue.add(new OrangeCell(i,j));
            }
        }
        queue.add(new OrangeCell(-1,-1));
        while(!queue.isEmpty()){
            boolean flag=false;
            while(!isDelima(queue.peek())){
                OrangeCell cell= queue.poll();
                for(int i=0;i<4;i++){
                    int nextX= cell.x+dx[i];
                    int nextY= cell.y+dy[i];
                    if(isValid(R,C,nextX,nextY) && grid[nextX][nextY]==1){
                        if(!flag){
                            time++;
                            flag=true;
                        }
                        grid[nextX][nextY]=2;
                        queue.add(new OrangeCell(nextX,nextY));
                    }
                }
            }
            queue.poll();
            if(!queue.isEmpty())
                queue.add(new OrangeCell(-1,-1));
        }
        if(check(grid,R,C))
            return -1;
        return time;
    }

    private static boolean isValid(int r, int c, int nextX, int nextY) {
        return (nextX>=0 && nextX<r && nextY>=0 && nextY<c);
    }

    private static boolean isDelima(OrangeCell cell) {
        return cell.x==-1 && cell.y==-1;
    }

    private static boolean check(int[][] grid,int R,int C){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1)
                    return true;
            }
        }
        return false;
    }
}
