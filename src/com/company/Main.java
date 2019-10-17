package com.company;

import java.io.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        DGIM dgim = new DGIM(1000);
        try(BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(
                                            "cmsc5741_stream_data1.txt")))) {
            while(true){
                int c = reader.read();
                if(c==-1){
                    break;
                }
                DGIM.number++;
                if((char)c=='1'){
                    dgim.add();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Bucket> iterator = dgim.getQueue().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("The count of 1: "+ dgim.getContent());
    }
}
