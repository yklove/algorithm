package cn.yklove.leetcode.contest.weekly296;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode4 {


    class TextEditor {

        StringBuilder stringBuilder;
        int index;

        public TextEditor() {
            stringBuilder = new StringBuilder();
            index = 0;
        }

        public void addText(String text) {
            stringBuilder.insert(index, text);
            index += text.length();
        }

        public int deleteText(int k) {
            int count = Math.max(index - k, 0);
            stringBuilder.delete(count, index);
            int ans = index - count;
            index = count;
            return ans;
        }

        public String cursorLeft(int k) {
            int left = Math.max(index - k, 0);
            index = left;
            left = Math.max(index - 10, 0);
            return stringBuilder.substring(left, index);
        }

        public String cursorRight(int k) {
            int right = Math.min(index + k, stringBuilder.length());
            index = right;
            int left = Math.max(index - 10, 0);
            return stringBuilder.substring(left, index);
        }
    }

    TextEditor textEditor = new TextEditor();

    @Test
    public void test() {
        textEditor = new TextEditor();
        textEditor.addText("leetcode");
        Assert.assertEquals(textEditor.deleteText(4), 4);
        textEditor.addText("practice");
        Assert.assertEquals(textEditor.cursorRight(3), "etpractice");
        Assert.assertEquals(textEditor.cursorLeft(8), "leet");
        Assert.assertEquals(textEditor.deleteText(10), 4);
        Assert.assertEquals(textEditor.cursorLeft(2), "");
        Assert.assertEquals(textEditor.cursorRight(6), "practi");
    }

}
