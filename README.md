### ⚙️ Módulo Paralelo (Matheus - Elemento A)

As classes responsáveis pelo processamento paralelo (`ThreadOrdenadora` e `ThreadJuntadora`) foram implementadas estendendo a classe nativa `Thread` do Java. Para o correto funcionamento e integração com as demais partes do projeto, observe os seguintes pontos:

1. **Dependência de Contratos (Parte B):** 
   O módulo paralelo não implementa a lógica do algoritmo, mas sim a orquestração. Ele assume que a classe `MergeSort` possui os seguintes métodos estáticos e públicos:
   - `MergeSort.sort(byte[] v)` — chamado pelas *ThreadOrdenadoras*.
   - `MergeSort.merge(byte[] a, byte[] b)` — chamado pelas *ThreadJuntadoras*.
   *(Atenção: Qualquer alteração na assinatura desses métodos quebrará a compilação do módulo paralelo).*

2. **Extração de Resultados e Sincronismo:** 
   O fluxo assíncrono exige que os resultados sejam extraídos apenas após a conclusão da thread. Para recuperar os vetores, o fluxo coordenador (`OrdenadorParalelo`) deve obrigatoriamente:
   - Iniciar a thread com `thread.start()`
   - Aguardar sua finalização usando `thread.join()`
   - Recuperar o valor final com `thread.getResultado()`
   *(Tentar usar `getResultado()` antes do `join()` retornará `null`).*

3. **Rastreabilidade (Logs):** 
   Para cumprir os requisitos do enunciado, as threads emitem avisos no console indicando a quantidade de elementos processados. O formato padronizado adotado é: `[LOG] NomeDaThread ...`

4. **Consumo de Memória:** 
   Como o MergeSort cria novos arrays a cada divisão/junção, o paralelismo exige bastante da RAM. Para testes com vetores próximos ao limite da máquina (`MaiorVetorAproximado`), é obrigatório rodar o `MainParalelo` com a flag de alocação da JVM (ex: `java -Xmx8G MainParalelo`), evitando `OutOfMemoryError`.