/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhighscoretable;

import java.util.Comparator;

/**
 *
 * @author omen
 */
public class SortbyScore implements Comparator<ValuesDetails>{

    @Override
    public int compare(ValuesDetails o1, ValuesDetails o2) {
        return o2.getScore() - o1.getScore();
    }
    
}
