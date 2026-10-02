# Programacao Paralela

Projeto de comparacao entre Merge Sort sequencial e Merge Sort paralelo.

## Estrutura

- `src/Util.java`: leitura, geracao e impressao de vetores.
- `src/MaiorVetorAproximado.java`: estimativa de maior vetor suportado com memoria limitada.
- `docs/diario.md`: registro das atividades com data e hora.
- `docs/relato.md`: resumo dos testes e conclusao.

## Compilacao

```sh
javac src/*.java
```

## Execucao do teste de memoria

```sh
java -Xmx8G -cp src MaiorVetorAproximado
```
