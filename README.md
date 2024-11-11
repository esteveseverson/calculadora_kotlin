# Calculadora Básica em Kotlin para Android

Este é um projeto da disciplina de desenvolvimento mobile (atividade 6), consiste no desenvolvimento de uma calculadora básica, desenvolvida em Kotlin, utilizando uma `Empty Activity` e `ConstraintLayout` no Android Studio. A calculadora permite realizar operações de adição, subtração, multiplicação e divisão.

## Estrutura do Projeto

### Layout (`activity_main.xml`)

O layout foi construído usando `ConstraintLayout` e um `GridLayout` para organizar os botões da calculadora. Ele inclui:

- Um `TextView` (id: `display`) para exibir os valores e resultados das operações.
- Botões para os números (0-9) e operações básicas (`+`, `-`, `*`, `/`, `=`).
- Um botão "C" para limpar a tela e reiniciar a calculadora.

### Código Kotlin (`MainActivity.kt`)

A lógica da calculadora foi implementada em `MainActivity.kt`, com as seguintes funcionalidades principais:

- **Display**: Exibe o valor atual inserido pelo usuário ou o resultado das operações.
- **Botões Numéricos**: Cada botão adiciona seu valor ao `display` e permite a construção do número a ser operado.
- **Botões de Operação**: Operações matemáticas básicas são realizadas na função `onOperation`, que:
    - Armazena o valor inserido como `operand1` na primeira operação.
    - Realiza operações sucessivas de acordo com o botão de operação pressionado.
    - Define a operação como `pendingOperation` até que a próxima operação seja escolhida.
- **Botão "C" (Clear)**: Limpa o `display` e redefine os valores da calculadora.

#### Funções principais

- `onOperation()`: Determina a operação a ser realizada e executa operações sequenciais conforme necessário.
- `performOperation()`: Realiza a operação matemática correspondente e retorna o resultado.

## Como Usar

1. Abra o projeto no Android Studio e execute o aplicativo em um dispositivo ou emulador Android.
2. Use os botões numéricos para inserir o valor.
3. Pressione um dos botões de operação (`+`, `-`, `*`, `/`) para definir a operação desejada.
4. Pressione `=` para ver o resultado.
5. Pressione `C` para limpar o `display` e redefinir a calculadora.

## Requisitos

- **Android Studio**: Versão 4.0 ou superior.
- **SDK Android**: Compilado com Android SDK 34 ou superior.
