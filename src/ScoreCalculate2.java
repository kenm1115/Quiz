

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
 * Servlet implementation class ScoreCalculate2
 */
@WebServlet("/ScoreCalculate2")
public class ScoreCalculate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = request.getParameter("q2");
		int score2 = 0;
		int answer = 12;
		Score sco = new Score();
		HttpSession session = request.getSession();

		if(a == null || a.isEmpty()) {
			String message = "入力されていません。";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/question2.jsp").forward(request, response);
			return;
		}


		Pattern patternNumber = Pattern.compile("[0-9]+");
		Matcher matcherNumber = patternNumber.matcher(a);
		if(!matcherNumber.matches()) {
			String message = "半角数字で入力して下さい。";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/question2.jsp").forward(request, response);
			return;
		}


		int q2 = Integer.parseInt(a);



		if(q2 == answer) {
			String message = "正解です。";
			request.setAttribute("message", message);
			score2 += 50;
			sco.setScore2(score2);
			session.setAttribute("score2", score2);
			request.getRequestDispatcher("/true2.jsp").forward(request, response);
			return;
		}

		String message = "不正解です。正解は"+ answer +"です。";
		request.setAttribute("message", message);
		  sco.setScore2(score2);
		 session.setAttribute("score2", score2);
		  request.getRequestDispatcher("/true2.jsp").forward(request, response);
	}

}
