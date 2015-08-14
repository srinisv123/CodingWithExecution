import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * /**Your previous Java content is preserved below:

 import java.io.*;
 import java.util.*;

 /*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


 Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list. This iterator should provide three public class member functions:

 boolean has_next()
 return true or false if there is another element in the set

 int next()
 return the value of the next element in the set

 void remove()
 remove the last element returned by the iterator.  That is, remove the element that the previous next() returned
 This method can be called only once per call to next(), otherwise, an exception will be thrown.


 The code should be well structured, and robust enough to handle any access pattern.  Additionally, write code to demonstrate that the class can be used for the following basic scenarios:


 Print elements
 Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
 Print:  1 2 3 4 5 6 7 8 9 10

 Remove even elements
 Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
 Should result in:  [[],[1,3],[5],[],[],[],[7],[],[9],[],[]]
 Print:  1 3 5 7 9




* @author ssingan on 8/6/15.
 */
public class ArrayOfArrayIterator {

    ArrayList<LinkedList<Integer>> list;


    Iterator<LinkedList<Integer>> rowIterator;
    Iterator<Integer> colIterator;
    boolean calledNext;

    public ArrayOfArrayIterator(int[][] elements) {
        list = new ArrayList<>();

        for (int[] row : elements) {
            LinkedList<Integer> innerList = new LinkedList<>();
            for(int element : row) {
                 innerList.add(element);
            }
            list.add(innerList);
        }
        calledNext = false;
        rowIterator = list.iterator();
        colIterator = list.get(0).iterator();
    }

    public int[][] getRawElements(){

        int[][] result = new int[list.size()][];
        int count =0;
        for(LinkedList<Integer> eachList : list) {
            result[count] = new int[eachList.size()];
            int rowCount =0;
            for(Integer element : eachList) {
                    result[count][rowCount++] = element;
            }
            count++;
        }

        return result;
    }




    public boolean has_next() {
        if(colIterator.hasNext()) {
           return true;

        }

        while(rowIterator.hasNext()) {
           colIterator = rowIterator.next().iterator();
            if (colIterator.hasNext()) {
                return true;
            }
        }

        return false;
    }

    public int next() {
        if (has_next()) {
            calledNext = true;
            return colIterator.next();
        }

        calledNext = false;
        throw new NoSuchElementException("No such element");
    }

    public void remove() {
        if (calledNext) {
            colIterator.remove();
            calledNext = false;
        } else {
            throw new IllegalAccessError("Not allowed");
        }
    }



}
