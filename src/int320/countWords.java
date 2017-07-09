/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author mosza16
 */
public class countWords {

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Word> map = new HashMap<>();
        Scanner input = new Scanner(new FileInputStream("text.txt"));
        int i = 0;// i for count position
        while (input.hasNextLine()) {
            String textLine = input.nextLine();
            StringTokenizer st = new StringTokenizer(textLine, " ,'\"");
            while (st.hasMoreTokens()) {
                String b = st.nextToken();
                if (map.containsKey(b)) {
                    Word w = map.get(b);
                    int count = w.getCount();
                    w.setCount(++count);
                    w.getPosition().add(i);
                    map.replace(b, w);
                } else {
                    Word w = new Word(1);
                    w.getPosition().add(i);
                    map.put(b, w);
                }
                i++;
            }
        }
        System.out.println(map);
    }

    public static class Word {
        List<Integer> positions = new ArrayList<>();
        int count;

        public Word(int count) {
            this.count = count;
        }

        public List<Integer> getPosition() {
            return positions;
        }

        public void setPosition(List<Integer> positions) {
            this.positions = positions;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Word{" + "position=" + positions + ", count=" + count + '}' + "\n";
        }

    }
}
