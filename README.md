# Hearthstone Cards

<p align="center">
 <img alt="Language" src="https://img.shields.io/static/v1?label=language&message=Kotlin&color=00FF7F&labelColor=000000">
</p>

App Android, que tem como objetivo mostrar uma lista de cartas do Hearthstone e exibir imagem e informações da carta selecionada.

## Projeto

Foi utilizado MVVM, como padrão de projeto e as seguintes dependências:

- Coroutines
- Navigation
- Glide
- Retrofit2
- OkHttp
- Gson
- Logger
- Koin

## Melhorias

- Ajustar chamada para informações das cartas
- Adicionar testes unitários com Mockito ou Mockk
- Adicionar testes instrumentados com Espresso
- Componentizar elementos repetidos, principalmente na tela de informações da carta
- Utilizar o Room para salvar informações das cartas mais vistas ou mais recentes, para não precisar realizar chamada na Api
- Adicionar botão de voltar na toolbar da tela de infomações da carta
- Realizar a troca dos layouts em XML para utilização do Compose