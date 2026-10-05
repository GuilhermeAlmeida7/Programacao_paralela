# Programacao Paralela

Projeto de comparacao entre Merge Sort sequencial e Merge Sort paralelo para vetores de `byte`.

## Estrutura

- `src/MergeSort.java`: algoritmo base sequencial e merge de dois vetores ordenados.
- `src/MainSequencial.java`: execucao sem paralelismo, com menu, logs e medicao de tempo.
- `src/ThreadOrdenadora.java`: thread que ordena uma parte do vetor.
- `src/ThreadJuntadora.java`: thread que junta dois vetores ordenados.
- `src/OrdenadorParalelo.java`: divide o vetor, dispara threads e junta os resultados.
- `src/MainParalelo.java`: execucao paralela, com menu, logs e medicao de tempo.
- `src/Util.java`: leitura, geracao e impressao de vetores.
- `src/MaiorVetorAproximado.java`: estimativa de maior vetor suportado com memoria limitada.
- `src/TestesOrdenacao.java`: comparacao automatica entre ordenacao sequencial e paralela.
- `docs/diario.md`: registro das atividades com data e hora.
- `docs/relato.md`: resumo dos testes e conclusao.
- `docs/prints/`: capturas de tela dos programas em execucao.

## Compilacao

```sh
javac src/*.java
```

## Execucao dos programas principais

```sh
java -cp src MainSequencial
java -cp src MainParalelo
```

## Execucao dos testes

Com tamanhos padrao:

```sh
java -cp src TestesOrdenacao
```

Com tamanhos escolhidos:

```sh
java -cp src TestesOrdenacao 1000 10000 100000 1000000
```

## Execucao do teste de memoria

```sh
java -Xmx8G -cp src MaiorVetorAproximado
```

## Contratos usados na integracao

```java
public static byte[] sort(byte[] v)
public static byte[] merge(byte[] a, byte[] b)
public static byte[] ordenar(byte[] v)
public static byte[] gerarAleatorio(int n)
public static byte[] lerManual(int n)
public static void imprimir(byte[] v, int ini, int fim)
```

## Observacoes

As threads usam `start()` e `join()` para garantir que os resultados sejam recuperados somente apos a finalizacao. Os logs no console indicam as etapas da ordenacao e ajudam na demonstracao do funcionamento.
