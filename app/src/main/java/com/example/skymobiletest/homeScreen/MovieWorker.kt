package com.example.skymobiletest.homeScreen

import java.util.*

interface MovieWorkerInput {
    val movies: ArrayList<MovieModel>
}

class MovieWorker : MovieWorkerInput {

    override val movies: ArrayList<MovieModel>
        get() {

            val movieList = ArrayList<MovieModel>()

            val movie1 = MovieModel(
                    title = "Doutor Estranho",
                    overview = "Stephen Strange (Benedict Cumberbatch) leva uma vida bem sucedida como neurocirurgião. Sua vida muda completamente quando sofre um acidente de carro e fica com as mãos debilitadas. Devido a falhas da medicina tradicional, ele parte para um lugar inesperado em busca de cura e esperança, um misterioso enclave chamado Kamar-Taj, localizado em Katmandu. Lá descobre que o local não é apenas um centro medicinal, mas também a linha de frente contra forças malignas místicas que desejam destruir nossa realidade. Ele passa a treinar e adquire poderes mágicos, mas precisa decidir se vai voltar para sua vida comum ou defender o mundo.",
                    duration = "1h 55m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w1280/dsAQmTOCyMDgmiPp9J4aZTvvOJP.jpg",
                    id = "090f0d8fs9d0dfdf"
            )
            val movie2 = MovieModel(
                    title = "Kong: A Ilha da Caveira",
                    overview = "Um grupo de desbravadores acompanhado de um ex-militar viaja para a mítica Ilha da Caveira, onde seu irmão desapareceu enquanto procurava o soro que teria o poder de curar todas as doenças conhecido como Titan. O homem, além de resgatar o irmão, terá de enfrentar as criaturas que habitam o local e, junto da equipe de exploradores, se aventurar nas profundezas da ilha desconhecida no Pacífico. O que não sabem é que o local é tão bonito quanto traiçoeiro e que estão atravessando para o domínio do mítico Kong.",
                    duration = "1h 58m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w1280/vAyQkuAozNiad5pjOW7yJlnxtxb.jpg",
                    id = "43294394329h32"
            )
            val movie3 = MovieModel(
                    title = "Capitão América: Guerra Civil",
                    overview = "Steve Rogers (Chris Evans) é o atual líder dos Vingadores, super-grupo de heróis formado por Viúva Negra (Scarlett Johansson), Feiticeira Escarlate (Elizabeth Olsen), Visão (Paul Bettany), Falcão (Anthony Mackie) e Máquina de Combate (Don Cheadle). O ataque de Ultron fez com que os políticos buscassem algum meio de controlar os super-heróis, já que seus atos afetam toda a humanidade. Tal decisão coloca o Capitão América em rota de colisão com Tony Stark (Robert Downey Jr.), o Homem de Ferro.",
                    duration = "2h 17m",
                    release_year = "2016",
                    cover_url = "https://image.tmdb.org/t/p/w640/jAXZMCG9rEXHUvfxTwEYEmO1V4p.jpg",
                    id = "83028903289032n243"
            )
            val movie4 = MovieModel(
                    title = "Interestelar",
                    overview = "Após ver a Terra consumindo boa parte de suas reservas naturais, um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper (Matthew McConaughey) é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand (Anne Hathaway), Jenkins (Marlon Sanders) e Doyle (Wes Bentley), ele seguirá em busca de uma nova casa. Com o passar dos anos, sua filha Murph (Mackenzie Foy e Jessica Chastain) investirá numa própria jornada para também tentar salvar a população do planeta.",
                    duration = "1h 55m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w640/o2eH7rg6XlWLkyjNVAIxQcWkQzi.jpg",
                    id = "83028903289032n244"
            )
            val movie5 = MovieModel(
                    title = "A Bela e a Fera",
                    overview = "Moradora de uma pequena aldeia francesa, Bela (Emma Watson) tem o pai capturado pela Fera e decide entregar sua vida ao estranho ser em troca da liberdade do progenitor. No castelo ela conhece objetos mágicos e descobre que a Fera é na verdade um príncipe que precisa de amor para voltar à forma humana.",
                    duration = "2h 03m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w640/9V4wl4rnUcLfGuTe4J5NjOFbDil.jpg",
                    id = "843249038904320849"
            )
            val movie6 = MovieModel(
                    title = "Logan",
                    overview = "Em 2029, Logan (Hugh Jackman) ganha a vida como chofer de limousine para cuidar do nonagenário Charles Xavier (Patrick Stewart). Debilitado fisicamente e esgotado emocionalmente, ele é procurado por Gabriela (Elizabeth Rodriguez), uma mexicana que precisa da ajuda do ex-X-Men para defender a pequena Laura Kinney / X-23 (Dafne Keen). Ao mesmo tempo em que se recusa a voltar à ativa, Logan é perseguido pelo mercenário Donald Pierce (Boyd Holbrook), interessado na menina.",
                    duration = "2h 15m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w1280/45Y1G5FEgttPAwjTYic6czC9xCn.jpg",
                    id = "93i29i4322nljl133"
            )
            val movie7 = MovieModel(
                    title = "Estrelas Além do Tempo",
                    overview = "Ano 1961, em plena Guerra Fria, Estados Unidos e União Soviética disputam a supremacia na corrida espacial ao mesmo tempo em que a sociedade norte-americana lida com uma profunda cisão racial, entre brancos e negros. Tal situação é refletida também na NASA, onde um grupo de funcionárias negras é obrigada a trabalhar a parte. É lá que estão Katherine Johnson (Taraji P. Henson), Dorothy Vaughn (Octavia Spencer) e Mary Jackson (Janelle Monáe), grandes amigas que, além de provar sua competência dia após dia, precisam lidar com o preconceito arraigado para que consigam ascender na hierarquia da NASA.",
                    duration = "1h 41m",
                    release_year = "2016",
                    cover_url = "https://image.tmdb.org/t/p/w1280/x0TIjXyI9BpEqlAF2I6TnwPXY8v.jpg",
                    id = "9439288989sa1"
            )
            val movie8 = MovieModel(
                    title = "O Poderoso Chefinho",
                    overview = "Um bebê falante que usa terno e carrega uma maleta misteriosa une forças com seu irmão mais velho invejoso para impedir que um inescrupuloso CEO acabe com o amor no mundo. A missão é salvar os pais, impedir a catástrofe e provar que o mais intenso dos sentimentos é uma poderosa força.",
                    duration = "1h 37m",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w1280/67NXPYvK92oQgEQvLppF2Siol9q.jpg",
                    id = "9439288989sa3"
            )
            val movie9 = MovieModel(
                    title = "De Volta ao Jogo",
                    overview = "John Wick (Keanu Reeves) já foi um dos assassinos mais temidos da cidade de Nova York, trabalhando em parceria com a máfia russa. Um dia, ele decide se aposentar, e neste período tem que lidar com a triste morte de sua esposa. Vítima de uma doença grave, ela já previa a sua própria morte, e deu de presente ao marido um cachorro para cuidar em seu período de luto. No entanto, poucos dias após o funeral, o cachorro é morto por ladrões que roubam o seu carro. John Wick parte em busca de vingança contra estes homens que ele já conhecia muito bem, e que roubaram o último símbolo da mulher que ele amava.",
                    duration = "1h 41m",
                    release_year = "2014",
                    cover_url = "https://image.tmdb.org/t/p/w1280/rboZslo3eQWKBQ3QvlO6wGV0J3K.jpg",
                    id = "9439288989sa6"
            )
            val movie10 = MovieModel(
                    title = "Rogue One: A Star Wars Story",
                    overview = "A rogue band of resistance fighters unite for a mission to steal the Death Star plans and bring a new hope to the galaxy.",
                    duration = "2h 13m",
                    release_year = "2016",
                    cover_url = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/qjiskwlV1qQzRCjpV0cL9pEMF9a.jpg",
                    id = "5866690702d6187f95a9eb87"
            )
            val movie11 = MovieModel(
                    title = "Mulher-Maravilha ",
                    overview = "Antes de ser Mulher-Maravilha, ela era Diana, princesa das Amazonas, treinada para ser uma guerreira imbatível. Criada numa ilha paraíso protegida e escondida, tudo muda quando um piloto americano chega em seu território e avisa sobre um grande conflito tomando forma no mundo. Diana deixa seu lar convencida de que pode impedir a ameaça crescente. Lutando ao lado dos homens em uma guerra para dar fim a todas as outras, Diana descobre seus poderes… e seu destino.",
                    duration = "141",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w200_and_h300_bestv2/ujQthWB6c0ojlARk28NSTmqidbF.jpg",
                    id = "595a3ee9d2ca9811005e6c4c"
            )
            val movie12 = MovieModel(
                    title = "A Múmia",
                    overview = "Nas profundezas do deserto, uma antiga rainha (Sofia Boutella) cujo destino foi injustamente tirado está mumificada. Apesar de estar sepultada em sua cripta, ela desperta nos dias atuais. Com uma maldade acumulada ao longo dos anos, ela espelha terror desde as areais do Oriente Médio até os becos de Londres.",
                    duration = "147",
                    release_year = "2017",
                    cover_url = "https://image.tmdb.org/t/p/w640/zxkY8byBnCsXodEYpK8tmwEGXBI.jpg",
                    id = "595a40efd2ca9811005e6c4d"
            )
            
            movieList.add(movie1)
            movieList.add(movie2)
            movieList.add(movie3)
            movieList.add(movie4)
            movieList.add(movie5)
            movieList.add(movie6)
            movieList.add(movie7)
            movieList.add(movie8)
            movieList.add(movie9)
            movieList.add(movie10)
            movieList.add(movie11)
            movieList.add(movie12)

            return movieList
        }
}