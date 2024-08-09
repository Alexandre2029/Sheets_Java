# Sobre o Projeto
Este projeto consiste em um programa Java que utiliza a API do Google Sheets para automatizar o processamento de calculo de media dos alunos com base em uma planilha com notas e numero de faltas dos alunos.

# Funcionalidades
Main: Esta classe principal coordena a execução do programa, interagindo com outras classes para ler os dados da planilha, calcular estatísticas e atualizar os resultados na planilha.

ServiceBuilder: Esta classe é responsável por construir o serviço do Google Sheets necessário para interagir com a API do Google Sheets.

SheetsValues: Esta classe contém métodos para obter os valores da planilha, calcular o total de aulas e definir novos valores na planilha.

calculations: Esta classe contém métodos para calcular a situação do aluno com base em suas notas e faltas, além de calcular a nota necessária para aprovação em caso de exame final.

SheetsCredential: Esta classe encapsula a lógica para obter e gerenciar as credenciais de acesso à API do Google Sheets, facilitando a autenticação e autorização necessárias para interagir com as planilhas do Google Sheets.
