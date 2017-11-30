# Homework 2 - Queues and Stacks

In this assignment, you will use the stack and queue implementations from the Java Collections API in order to build a program that determines whether an HTML page is well formatted.

In completing this assignment, you will:

- Become familiar with the methods in the java.util.Stack class and java.util.Queue interface
- Work with an abstract data type (specifically, queues) by using only the interface of an implementation
- Apply what you have learned about how stacks and queues work

## Getting Started
Download [HtmlReader.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/ef5af89c3f24fdd51d02cf32a02bae6a/asset-v1:PennX+SD2x+2T2017+type@asset+block/HtmlReader.java) and [HtmlTag.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/8b48139f29c4a2d9688f2026a0c5ae78/asset-v1:PennX+SD2x+2T2017+type@asset+block/HtmlTag.java), which contain code that you can use in this assignment. You should not change either of these implementations for this assignment.

**HtmlTag.java** represents information about a single HTML tag. Methods that may be useful to you:

- **getElement()** Gets the element name (String) specified in this tag.
- **isOpenTag()** Checks whether this is the opening tag. If the tag is either the closing tag or self-closing (e.g. **<br/**> is a line break tag that doesn’t need any accompanying text), **isOpenTag** will return **false**.
- **isSelfClosing()** Checks whether a tag is self-closing (e.g. **\<br/>**)
- **matches(HtmlTag other)** Checks whether an HtmlTag **other** is the matching open/close tag to itself (e.g. **\<b>** and **\</b>** or vice versa).

In **HtmlReader.java** you will find a method called **getTagsFromFile** that reads in the path to an HTML file and separates it into tokens. The output is a representation of the HTML file as a Queue of _HtmlTags_ in the order in which they were encountered. You may edit this code if you'd like, but please do not modify _HtmlTag.java_.

Also download [HtmlValidator.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/43aebc8e920acdc8f533288f3700ef6e/asset-v1:PennX+SD2x+2T2017+type@asset+block/HtmlValidator.java), which contains the unimplemented method for the code that you will write in this assignment.

## Activity
In **HtmlValidator.java**, implement the **isValidHtml** method. **isValidHtml** should take as input a Queue of HtmlTags and return a Stack of HtmlTags that verifies the correctness of the tag structure, according to the specification described below.

The method should be implemented as follows:

If the HTML file is well formatted, the method should return an empty Stack. For example:

`<html><body><h1>heading</h1><p>paragraph</p></body></html>`

In this case, the closing tags match the opening tags, so the HTML is valid. When you get to the end of the file/Queue, the Stack is empty.

If the HTML file is not well formatted, the method should return the Stack in its current state (i.e., with its current values) at the time the code determined that the tags were not balanced.