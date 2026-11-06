package kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web.xml에 등록된 URL 요청을 받아 HTML을 응답하는 서블릿.
 * 객체 생성과 생명주기는 Spring이 아닌 Tomcat이 관리한다.
 */
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        log("TestServlet init(): 서블릿 초기화");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log("TestServlet doGet(): " + request.getRequestURI());
        String view;
        try {
            String id = request.getParameter("id");
            if (id == null || id.isBlank()) {
                throw new IllegalArgumentException("아이디를 입력해 주세요.");
            }

            // 이후 서비스 호출이 필요하면 이 위치에 추가한다.
            // 같은 요청을 JSP로 전달하므로 입력값을 request에 담는다.
            request.setAttribute("id", id);
            view = "/WEB-INF/views/ok.jsp";
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "아이디를 입력해 주세요.");
            view = "/WEB-INF/views/fail.jsp";
        } catch (RuntimeException e) {
            log("입력 처리 중 오류", e);
            request.setAttribute("errorMessage", "처리 중 오류가 발생했습니다. 다시 시도해 주세요.");
            view = "/WEB-INF/views/fail.jsp";
        }

        // 서블릿은 처리와 화면 선택을 담당하고, HTML 작성은 JSP가 담당한다.
        request.getRequestDispatcher(view).forward(request, response);
    }

    @Override
    public void destroy() {
        log("TestServlet destroy(): 서블릿 종료");
        super.destroy();
    }
}
