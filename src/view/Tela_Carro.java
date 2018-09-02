
package view;

import dao.CarroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Carro;

public class Tela_Carro implements ActionListener{

    Carro c = new Carro();
    CarroDAO cDao = new CarroDAO();
    
    JFrame janela = new JFrame("Cadastro de carro");
    JPanel painel = new JPanel();
    
    JLabel lbcodigo = new JLabel("Codigo: ");
    JLabel lbmodelo = new JLabel("Modelo: ");
    JLabel lbmarca = new JLabel("Marca: ");
    JLabel lbvalor = new JLabel("Valor: ");
    
    JTextField txtcodigo = new JTextField();
    JTextField txtmodelo = new JTextField();
    JTextField txtmarca = new JTextField();
    JTextField txtvalor = new JTextField();
    
    JButton btsalvar = new JButton("Salvar");
    JButton btpesquisar = new JButton("Pesquisar");
    JButton btalterar = new JButton("Alterar");
    JButton btexcluir = new JButton("Excluir");
    
    void criarTela(){
        
		janela.setSize(350,  250);//tamanha ( largura, altura)
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocation(300, 300);//posiçao
		painel.setLayout(null);//layout padrão
		
		lbcodigo.setBounds(10, 10, 100, 30);
		txtcodigo.setBounds(110, 10, 100, 30);
		
		lbmodelo.setBounds(10, 40, 100, 30);
		txtmodelo.setBounds(110, 40, 100, 30);
		
		lbmarca.setBounds(10, 70, 100, 30);
		txtmarca.setBounds(110, 70, 100, 30);
		
		lbvalor.setBounds(10, 100, 100, 30);
		txtvalor.setBounds(110, 100, 100, 30);
	
		btsalvar.setBounds(10, 170, 100, 30);
		btsalvar.addActionListener(this);//acao do botao
		
		btpesquisar.setBounds(210, 10, 100, 30);
		btpesquisar.addActionListener(this);//acao do botao
		
		btalterar.setBounds(110, 170, 100, 30);
		btalterar.addActionListener(this);//acao do botao
		
		btexcluir.setBounds(210, 170, 100, 30);
		btexcluir.addActionListener(this);//acao do botao
		
	//	lbmarca.setBounds(10, 70, 100, 30);
	//	txtmarca.setBounds(10, 100, 100, 30);

		painel.add(lbcodigo);
		painel.add(txtcodigo);
		painel.add(lbmodelo);
		painel.add(txtmodelo);
		painel.add(lbmarca);
		painel.add(txtmarca);
		painel.add(lbvalor);
		painel.add(txtvalor);
		
		painel.add(btsalvar);
		painel.add(btpesquisar);
		painel.add(btalterar);
		painel.add(btexcluir);
	
		
		janela.getContentPane().add(painel);
		janela.setVisible(true);
	}// fim do criar tela    
    
    public static void main(String[] args){
        Tela_Carro c = new Tela_Carro();
        c.criarTela();
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btsalvar){
			c.setCodigo(Integer.parseInt(txtcodigo.getText()));
			c.setModelo(txtmodelo.getText());
			c.setMarca(txtmarca.getText());
			c.setValor(Double.parseDouble(txtvalor.getText()));
			
			cDao.insert(c);
			
			txtcodigo.setText("");
			txtmodelo.setText("");
			txtmarca.setText("");
			txtvalor.setText("");
		}
		
		if(e.getSource() == btpesquisar){
		
                    for(Carro carro : cDao.pesquisar(Integer.valueOf(txtcodigo.getText()))){
                        txtmodelo.setText(carro.getModelo());
                        txtmarca.setText(carro.getMarca());
                        txtvalor.setText(carro.getValor().toString());
                    }
                    
                }
                
                if(e.getSource()== btalterar){
                    
                    c.setModelo(txtmodelo.getText());
                    c.setMarca(txtmarca.getText());
                    c.setValor(Double.parseDouble(txtvalor.getText()));
                    c.setCodigo(Integer.parseInt(txtcodigo.getText()));
                    
                    cDao.alterar(c);
                }
                
                if(e.getSource() == btexcluir){
                    cDao.excluir(Integer.valueOf(txtcodigo.getText()));
                    txtcodigo.setText("");
                    txtmodelo.setText("");
                    txtmarca.setText("");
                    txtvalor.setText("");
                }
		
	}
    
    
}
