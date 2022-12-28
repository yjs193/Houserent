package com.houserent.service;
import com.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;
    private int idCounter = 1;
    public HouseService(int size){
        houses = new House[size];
        houses[0] = new House(1,"jack","112","海淀区",2000,"未出租");
    }

    //list方法，返回houses
    public House[] list(){
        return houses;
    }

    public boolean add(House newHouse){

        //判断是否还可以继续添加
        if(houseNums ==houses.length){
            System.out.println("数组已满，不能再添加");
            return false;
        }

        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId){
        int index = -1;
        for(int i = 0;i < houseNums;i++){
            if(delId == houses[i].getId()){
                index = i;
            }
        }
        if( index == -1){
            return false;
        }

        for(int i = index;i<houseNums - 1;i++){
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;
        return true;
    }

    public House findById(int find_id){

        for (int i = 0; i < houseNums; i++) {
            if(find_id==houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
}
