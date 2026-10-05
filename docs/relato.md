# Relato

O projeto compara a ordenacao sequencial e paralela de vetores de bytes usando Merge Sort.
A versao paralela divide o vetor conforme a quantidade de processadores disponiveis, ordena as partes em threads e junta os resultados em rodadas de merge.
Os testes devem registrar tamanhos diferentes de entrada, tempo da execucao sequencial e tempo da execucao paralela.
Tambem deve ser executado o programa `MaiorVetorAproximado` com `-Xmx8G` para estimar um vetor grande na maquina usada.

## Resultados

| Tamanho | Sequencial | Paralelo | Observacao |
| --- | --- | --- | --- |
| 1.000 | 0.954277 ms | 77.410018 ms | Resultados iguais |
| 10.000 | 3.364552 ms | 3.09791 ms | Resultados iguais |
| 100.000 | 33.099215 ms | 29.320116 ms | Resultados iguais |

## Conclusao

Nos testes, o paralelo ficou pior no vetor pequeno porque o custo de criar threads e juntar partes foi maior que o ganho.
Com vetores maiores, o paralelismo passou a compensar e ficou mais rapido que a versao sequencial.
O programa `MaiorVetorAproximado` encontrou aproximadamente 1.073.741.824 posicoes com `java -Xmx8G -cp src MaiorVetorAproximado`.
