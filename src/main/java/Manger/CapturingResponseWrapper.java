package Manger;

import java.io.PrintWriter;
import java.io.CharArrayWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


public class CapturingResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter charArrayWriter = new CharArrayWriter();

    public CapturingResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(charArrayWriter);
    }

    public String getCapturedContent() {
        return charArrayWriter.toString();
    }
}