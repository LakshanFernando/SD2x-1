package Homeworks.SD2x.queues_and_stacks;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class HtmlValidatorTest {

    @Test
    public void isValidHtml() throws Exception {

        // Initialize
        Queue<HtmlTag> q = new LinkedList<>();
        Stack<HtmlTag> actual = new Stack<>();
        Stack<HtmlTag> expected = new Stack<>();

        // This html has closed in incorrect order
        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/html1.html");
        actual = HtmlValidator.isValidHtml(q);

        expected.push(new HtmlTag("html", true));
        expected.push(new HtmlTag("body", true));
        expected.push(new HtmlTag("p", true));
        expected.push(new HtmlTag("b", true));

        assertEquals(expected, actual);


        // This html has tags in the correct order
        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/html2.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        assertEquals(expected, actual);


        // This html has a closing tag with no opening tag
        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/html3.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        expected.push(new HtmlTag("html", true));
        expected.push(new HtmlTag("body", true));
        assertEquals(expected, actual);

        // This html has opening tags that are never closed
        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/html4.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        expected.push(new HtmlTag("html", true));
        expected.push(new HtmlTag("body", true));
        expected.push(new HtmlTag("b", true));
        assertEquals(expected, actual);

        // This html has closing tags with no opening tag
        // occurring at the very end.
        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/html5.html");
        actual = HtmlValidator.isValidHtml(q);
        assertNull(actual);

        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test2.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        expected.push(new HtmlTag("html", true));
        expected.push(new HtmlTag("b", true));
        assertEquals(expected, actual);

        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test3.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        expected.push(new HtmlTag("b", true));
        expected.push(new HtmlTag("i", true));
        assertEquals(expected, actual);


        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test4.html");
        actual = HtmlValidator.isValidHtml(q);
        assertNull(actual);


        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test5.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        assertEquals(expected, actual);


        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test6.html");
        actual = HtmlValidator.isValidHtml(q);
        expected.clear();
        expected.push(new HtmlTag("html", true));
        expected.push(new HtmlTag("head", true));
        expected.push(new HtmlTag("title", true));
        expected.push(new HtmlTag("p", true));
        assertEquals(expected, actual);

        q = HtmlReader.getTagsFromHtmlFile("submissions/Homeworks/SD2x/queues_and_stacks/htmls/test7.html");
        actual = HtmlValidator.isValidHtml(q);
        assertNull(actual);

    }
}