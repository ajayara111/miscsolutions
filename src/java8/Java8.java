/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.List;

/**
 *
 * @author Kishan
 */

public class Java8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("aa");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
    }
}
