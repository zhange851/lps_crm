package com.core.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class LpsTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try{
            pageContext.getResponse().getWriter().write("this is lps's tag");
        }catch(IOException e){
            e.printStackTrace();
            throw(new RuntimeException(e));
        }
        return super.doStartTag();
    }
}
