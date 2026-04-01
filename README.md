# Hub de Utilidades - Android App

Este é um aplicativo Android desenvolvido em **Java** que funciona como um hub centralizado para diversas ferramentas úteis. O projeto foca no gerenciamento de múltiplas *Activities*, navegação via *Intents*, passagem de parâmetros e persistência de estado.

## Funcionalidades

### 1. Menu Principal (MainActivity)
- Ponto central de navegação para todos os módulos do aplicativo.
- Interface intuitiva com botões para acesso rápido.

### 2. Gerador MegaSena
- Gera automaticamente 6 números aleatórios entre 01 e 60.
- Garante que não haja números repetidos no mesmo jogo.
- Ordenação automática dos números gerados.

### 3. Calculadora de IMC
- Calcula o Índice de Massa Corporal com base no peso (kg) e altura (m).
- Exibe a classificação correspondente (Abaixo do peso, Peso normal, Sobrepeso, etc.).

### 4. Jokenpo (Pedra, Papel e Tesoura)
- Jogo clássico contra o computador.
- **Lógica Melhor de 3**: O primeiro a marcar 2 pontos vence a partida.
- Botão de reiniciar disponível após o término do jogo.

### 5. Questionário da Felicidade
- Módulo exclusivo que avalia o bem-estar do usuário.
- Coleta dados sobre atividade atual (Estudo/Trabalho/Folga), horas de sono e nível de estresse.
- **Cálculo Ponderado**:
  - Peso do Sono (1 a 3 pts).
  - Peso do Estresse (1 a 3 pts).
  - Fórmula: `Felicidade = [(Sono + Estresse) / 6] * 10`.
- Tela de resultado com classificação de "Muito Baixa" a "Plena".

## Tecnologias Utilizadas

- **Linguagem:** Java
- **IDE:** Android Studio
- **Componentes UI:** ConstraintLayout, LinearLayout, ScrollView, RadioGroup, CheckBox, Buttons, TextViews.
- **Conceitos Android:**
  - `Intent` e `Bundle` para navegação e passagem de dados.
  - Ciclo de vida da Activity (`finish()`).
  - Lógica condicional e aritmética para cálculos de saúde e bem-estar.

## Como Executar

1. Clone o repositório ou baixe o código fonte.
2. Abra o projeto no **Android Studio**.
3. Sincronize o Gradle.
4. Execute em um emulador ou dispositivo físico com Android (API 24 ou superior recomendada).

## Licença

Este projeto foi desenvolvido para fins acadêmicos na FATEC.

## Aluno

Daniel Vigano da Silva
