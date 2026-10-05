# Programacao Paralela

Projeto de comparacao entre Merge Sort sequencial e Merge Sort paralelo.

## Estrutura

- `src/Util.java`: leitura, geracao e impressao de vetores.
- `src/MaiorVetorAproximado.java`: estimativa de maior vetor suportado com memoria limitada.
- `src/TestesOrdenacao.java`: comparacao automatica entre ordenacao sequencial e paralela.
- `docs/diario.md`: registro das atividades com data e hora.
- `docs/relato.md`: resumo dos testes e conclusao.
- `docs/prints/`: pasta para salvar prints dos testes e da execucao.

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

## Observacoes

As classes `MergeSort` e `OrdenadorParalelo` devem respeitar as assinaturas combinadas:

```java
public static byte[] sort(byte[] v)
public static byte[] merge(byte[] a, byte[] b)
public static byte[] ordenar(byte[] v)
```

Os utilitarios da parte C fornecem:

```java
public static byte[] gerarAleatorio(int n)
public static byte[] lerManual(int n)
public static void imprimir(byte[] v, int ini, int fim)
```
