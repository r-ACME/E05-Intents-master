# Android E05: Intents

Professor: João Eduardo Montandon

## Tela de Perfil

A tela de perfil é uma das telas mais comuns presentes nos aplicativos móveis. Geralmente, a tela de perfil contém os dados cadastrais do usuário do aplicativo, como nome, foto, e-mail e telefone.

Você deverá implementar uma tela de perfil interativa. Nessa tela, o usuário poderá visualizar os seguintes dados:

* Nome
* Foto de Perfil
* Idade
* E-mail
* Telefone

A tela deverá permitir que a foto de perfil seja alterada por uma da câmera do aparelho. Além disso, sua tela deverá abrir o discador quando o usuário tocar no número de telefone, e abrir o aplicativo de e-mail quando o campo de e-mail for tocado.

## Leitura de código de barras

*OBS: Para esse exercício você precisará instalar o aplicativo [Barcode Scanner](https://play.google.com/store/apps/details?id=com.google.zxing.client.android&hl=pt_BR).*

Implemente um aplicativo que, através do mecanismo de Intents, faça a leitura do código de barras de um determinado produto, e o exiba na tela para o usuário. Para isso, você deverá criar uma Intent que dispará a mensagem `"com.google.zxing.client.android.SCAN"`, e tratar o resultado no méto `onActivityResult()`.

Mais informações podem ser obtidas a partir deste [link](https://stackoverflow.com/questions/9006818/adding-a-barcode-scanner-to-an-android-application-just-to-decode-using-zxing).
