

# Testes de loja Presta Shop



Este é um projeto onde se realizou um teste automatizado para validar as funcionalidades do site. Nestas funcionalidades abarcou-se Login, adicionar um o vários produtos ao carrinho, eliminar um produto do carrinho e fazer o checkout da compra.



Pre requisitos:

* Java 14
* Intellij
* Maven
* Cucumber
* Junit
* Selenium
* Cluecumber para gerar reportes
* Surefire plugin
* Site https://marcelodebittencourt.com/demoprestashop/



Depois de executados os testes para gerar o reporte na linha de comando:

mvn cluecumber-report:reporting



## <u>Casos de testes</u>

* ### Login : usuário fazer login no site

| Cenário | Tipo de teste | Cenário de  teste                                            | Resultado  esperado                                          | status |
| ------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| C1      | Positivo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e escrever email  alirismaurera@gmail.com, senha 123456        clicar signin | Deveria  loga, ir para a pagina minha conta e mostrar o nome na pagina | Ok     |
| C2      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e deixar email vazio,  senha 123456 clicar signin | Deveria  ficar na mesma pagina de signin                     | Ok     |
| C3      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e escrever email  alirismaurera@gmail.com, se senha vazia        clicar signin | Deveria  ficar na mesma pagina de signin                     | Ok     |
| C4      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e deixar email e  senha vazia  clicar signin | Deveria  ficar na mesma pagina de signin                     | Ok     |
| C5      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e escrever email  invalido aliris@gmail.com, senha 123456        clicar signin | Deveria  ficar na mesma pagina de signin e mostrar uma mensagem de erro  "Authentication failed." | Ok     |
| C6      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e escrever email  alirismaurera@gmail.com, senha invalida 123489       clicar signin | Deveria  ficar na mesma pagina de signin e mostrar uma mensagem de erro  "Authentication failed." | Ok     |
| C7      | Negativo      | Usuario  estar na pagina https://marcelodebittencourt.com/demoprestashop/    clicar em signin e escrever email  invalido aliris@gmail.com, senha invalido 123489        clicar signin | Deveria  ficar na mesma pagina de signin e mostrar uma mensagem de erro  "Authentication failed." | Ok     |



* ### Adicionando um produto

| Cenário | Tipo de teste | Cenário de  teste                                            | Resultado  esperado                                          | status |
| ------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| C1      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar o produto:Hummingbird  printed t-shirt, tamanho: M, cor: Black, quantidade: 2 e clicar adicionar ao carrinho | Deveria  mostrar uma resumem do produto e uma messagem "Product successfully  added to your shopping cart" | Ok     |
| C2      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar o produto:Hummingbird  printed sweater, tamanho: L, cor: Black, quantidade: 3 e clicar adicionar ao carrinho | Deveria  mostrar uma resumem do produto e uma messagem "Product successfully  added to your shopping cart" | Ok     |
| C3      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar o produto:Framed poster  , dimensão:60x90cm, quantidade: 2 e  clicar adicionar ao carrinho | Deveria  mostrar uma resumem do produto e uma messagem "Product successfully  added to your shopping cart" | Ok     |
| C4      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar o produto:Mug The best  is yet to come, quantidade: 2 e clicar adicionar ao carrinho | Deveria  mostrar uma resumem do produto e uma messagem "Product successfully  added to your shopping cart" | Ok     |



* ### Adicionando varios produtos

| Cenário | Tipo de teste | Cenário de  teste                                            | Resultado  esperado                                          | status |
| ------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| C1      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar um produto, clicar no  carrinho, borrar o produto | Deveria  mostrar uma mensagem "There are no more items in your cart" e o  carrinho 0 itens | Ok     |
| C2      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar dois produtos um com  quantidade 3 e outro quantidade 2, clicar no carrinho, borrar o primeiro  produto de quantidade 3 | Deveria  mostrar os itens restantes e o carrinho disminuir a quantidade a 2 | Ok     |



* ### Checkout do produto

| Cenário | Tipo de teste | Cenário de  teste                                            | Resultado  esperado                                          | status |
| ------- | ------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------ |
| C1      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar um produto, clicar  proceed checkout, selecionar endereço, selecionas shiiping, selecionar opção  de pagamento, aceitar os termos e clicar proceed checkout | Deveria  mostrar uma resumem da compra e uma mensagem "YOUR ORDER IS  CONFIRMED" | Ok     |
| C2      | Positivo      | Usuario  estar lodado na pagina https://marcelodebittencourt.com/demoprestashop/   quando adicionar um produto, clicar  proceed checkout, selecionar endereço, selecionas shiiping, selecionar opção  de pagamento, aceitar os termos e clicar proceed checkout | Deveria  mostrar uma resumem da compra e uma mensagem "YOUR ORDER IS  CONFIRMED" | Ok     |