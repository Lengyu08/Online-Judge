<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!-- Editor Start -->
<!-- autocomplete 防止表单提交的时候重复显示 -->
<form id="codeForm" action="/servlet/Judge_Code" method="post" autocomplete="off">
  <div class="content" style="min-height:auto">
    <span class="title" style="font-size:30px;position: absolute; left: 12%;">代码编辑器</span>
    <span style="position: absolute; right:15%;">
        <span class="title">语言</span>
        <label>
          <select class="choose" name="language">
            <option value="text/x-c++src">C++</option>
            <option value="text/x-java">Java</option>
            <option value="python">Python</option>
          </select>
        </label>
      </span>
    <span style="position: absolute; right:30%;">
        <span class="title">编辑模式</span>
        <label>
          <select class="choose" name="mode">
            <option value="default">Text</option>
            <option value="vim">Vim</option>
          </select>
        </label>
      </span>
    <br/><br/><br/>
    <div id="editor" style="text-align: left;"></div>
    <br/>
    <a href="#" onclick="submitCode()" class="sublime_code">提交</a>
  </div>
</form>
<!-- Editor End -->
</div>
<!-- Content End -->

<%@ include file="/footer.jsp" %>
<% if(ans == null || ans.isEmpty()) ans = " "; %>
<% if (ans.equals("Please_login_first")) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("不接受非注册用户的提交!");
    }, 100);
  }
</script>
<% } else if (ans.equals("Please_enter_your_code")) { %>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("请输入你的代码!");
    }, 100);
  }
</script>
<%
} else if (ans.equals("Accepted")) { %>
<%
  if (roomID != null && !roomID.isEmpty()) {
      session.setAttribute("result", "2");
      response.sendRedirect("/servlet/Judge_Result");
  }
%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("恭喜你, 通过了这道题!");
    }, 100);
  }
</script>
<% } else if (ans.equals("Wrong_Answer")) { %>
<%
  if (roomID != null && !roomID.isEmpty()) {
    session.setAttribute("result", "1");
    response.sendRedirect("/servlet/Judge_Result");
  }
%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("与标准答案不符!");
    }, 100);
  }
</script>
<% } else if (ans.equals("Compilation_Error")) { %>
<%
  if (roomID != null && !roomID.isEmpty()) {
    session.setAttribute("result", "1");
    response.sendRedirect("/servlet/Judge_Result");
  }
%>
<script type="text/javascript">
  window.onload = function () {
    setTimeout(function () {
      alert("编译错误!");
    }, 100);
  }
</script>
<% } %>
</body>

<script src="/LIB/Code-Mirror/codemirror.min.js"></script>
<script src="/LIB/Code-Mirror/clike.min.js"></script>
<script src="/LIB/Code-Mirror/matchbrackets.min.js"></script>
<script src="/LIB/Code-Mirror/closebrackets.min.js"></script>
<script src="/LIB/Code-Mirror/matchtags.min.js"></script>
<script src="/LIB/Code-Mirror/closetag.min.js"></script>

<script src="/LIB/Code-Mirror/python.min.js"></script>

<script src="/LIB/Code-Mirror/vim.min.js"></script>

<script src="/JS/code-mirror.js"></script>

<script src="/LIB/Katex/katex.min.js"></script>

<script>
  document.addEventListener("DOMContentLoaded", function () {
    const mathElements = document.getElementsByClassName("math-expression");
    Array.from(mathElements).forEach(function (element) {
      katex.render(element.textContent, element, {
        throwOnError: false,
      });
    });
  });
</script>
</html>
