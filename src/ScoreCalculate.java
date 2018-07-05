

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Score;

/**
 * Servlet implementation class ScoreCalculate
 */
@WebServlet("/ScoreCalculate")
public class ScoreCalculate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = request.getParameter("q1");
		int answer = 2;
		int score = 0;
		Score sco = new Score();
		HttpSession session = request.getSession();

		if(a == null || a.isEmpty()) {
			String message = "入力されていません。";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/question1.jsp").forward(request, response);
			return;
		}


		Pattern patternNumber = Pattern.compile("[0-9]+");
		Matcher matcherNumber = patternNumber.matcher(a);
		if(!matcherNumber.matches()) {
			String message = "半角数字で入力して下さい。";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/question1.jsp").forward(request, response);
			return;
		}


		int q1 = Integer.parseInt(a);

		if(q1 == answer) {
			String message = "正解です。";
			request.setAttribute("message", message);
			score += 50;
			sco.setScore(score);
			session.setAttribute("score", score);
			request.getRequestDispatcher("/true.jsp").forward(request, response);
			return;
		}

		String message = "不正解です。正解は、"+ answer +"です。";
		request.setAttribute("message", message);
		sco.setScore(score);
		session.setAttribute("score", score);
		request.getRequestDispatcher("/true.jsp").forward(request, response);
    }

}
