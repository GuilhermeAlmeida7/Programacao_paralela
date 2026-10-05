# Relato

O projeto compara a ordenacao sequencial e paralela de vetores de bytes usando Merge Sort.
A versao paralela divide o vetor conforme a quantidade de processadores disponiveis, ordena as partes em threads e junta os resultados em rodadas de merge.
Os testes devem registrar tamanhos diferentes de entrada, tempo da execucao sequencial e tempo da execucao paralela.
Tambem deve ser executado o programa `MaiorVetorAproximado` com `-Xmx8G` para estimar um vetor grande na maquina usada.

## Resultados

Preencher apos a execucao em uma maquina com JDK instalado.

| Tamanho | Sequencial | Paralelo | Observacao |
| --- | --- | --- | --- |
| 1.000 |  |  |  |
| 10.000 |  |  |  |
| 100.000 |  |  |  |
| 1.000.000 |  |  |  |

## Conclusao

A conclusao deve comparar os tempos obtidos e comentar se o custo de criar e juntar threads compensou para vetores pequenos, medios e grandes.
Tambem deve registrar o maior vetor aproximado encontrado com `java -Xmx8G -cp src MaiorVetorAproximado`.
