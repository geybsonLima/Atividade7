import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

@WebServlet("/faturaServlet")
public class FaturaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6307200982001552647L;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
					
			String nome = req.getParameter("nomeCliente");
			String dataVencimento = req.getParameter("dataNascimento");
			String valorTotal = req.getParameter("valorTotal");
			String numeroBoleto = req.getParameter("numeroBoleto");
			
			PrintWriter out = res.getWriter();

			
			Fatura fatura = new Fatura();
			fatura.setNomeCliente(nome);
			fatura.setValorTotal(Double.parseDouble(valorTotal));
			fatura.setNumeroBoleto(Integer.parseInt(numeroBoleto));
			
			boolean erroConverter = false;
			
			try {
				Date dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(dataVencimento);
				fatura.setDataVencimento(dataConvertida);
			} catch (ParseException e) {
				erroConverter = true;
			}
			
			if(erroConverter = false){
				
				//dao Fatura aqui
				
				out.println("<html>");
				out.println("<body>");
				out.println("Rodou de boa!!");
				out.println("</body>");
				out.println("</html>");
		
				
			}else{
				out.println("<html>");
				out.println("<body>");
				out.println("erro!!");
				out.println("</body>");
				out.println("</html>");
			}
				
		
		}

}
