package com.rizqi.nontonkuy.data

import com.google.gson.Gson
import com.rizqi.nontonkuy.data.model.Movie
import com.rizqi.nontonkuy.data.model.Tv

class WebServices {
  private val tvsData = """[
        {
            "original_name": "The Mandalorian",
            "genre_ids": [
                10765,
                10759,
                37
            ],
            "name": "The Mandalorian",
            "popularity": 1862.187,
            "origin_country": [
                "US"
            ],
            "vote_count": 1950,
            "first_air_date": "2019-11-12",
            "backdrop_path": "/9ijMGlJKqcslswWUzTEwScm82Gs.jpg",
            "original_language": "en",
            "id": 82856,
            "vote_average": 8.4,
            "overview": "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
            "poster_path": "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
        },
        {
            "original_name": "Fear the Walking Dead",
            "genre_ids": [
                10759,
                18
            ],
            "name": "Fear the Walking Dead",
            "popularity": 765.736,
            "origin_country": [
                "US"
            ],
            "vote_count": 2483,
            "first_air_date": "2015-08-23",
            "backdrop_path": "/58PON1OrnBiX6CqEHgeWKVwrCn6.jpg",
            "original_language": "en",
            "id": 62286,
            "vote_average": 7.4,
            "overview": "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
            "poster_path": "/wGFUewXPeMErCe2xnCmmLEiHOGh.jpg"
        },
        {
            "original_name": "The Boys",
            "genre_ids": [
                10765,
                10759
            ],
            "name": "The Boys",
            "popularity": 646.36,
            "origin_country": [
                "US"
            ],
            "vote_count": 3389,
            "first_air_date": "2019-07-25",
            "backdrop_path": "/mGVrXeIjyecj6TKmwPVpHlscEmw.jpg",
            "original_language": "en",
            "id": 76479,
            "vote_average": 8.4,
            "overview": "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
            "poster_path": "/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"
        },
        {
            "original_name": "Lucifer",
            "genre_ids": [
                80,
                10765
            ],
            "name": "Lucifer",
            "popularity": 642.276,
            "origin_country": [
                "US"
            ],
            "vote_count": 6126,
            "first_air_date": "2016-01-25",
            "backdrop_path": "/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg",
            "original_language": "en",
            "id": 63174,
            "vote_average": 8.5,
            "overview": "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "poster_path": "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
        },
        {
            "original_name": "The Queen's Gambit",
            "genre_ids": [
                18
            ],
            "name": "The Queen's Gambit",
            "popularity": 553.476,
            "origin_country": [
                "US"
            ],
            "vote_count": 177,
            "first_air_date": "2020-10-23",
            "backdrop_path": "/34OGjFEbHj0E3lE2w0iTUVq0CBz.jpg",
            "original_language": "en",
            "id": 87739,
            "vote_average": 8.9,
            "overview": "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
            "poster_path": "/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg"
        },
        {
            "original_name": "The Walking Dead: World Beyond",
            "genre_ids": [
                18,
                10765,
                9648
            ],
            "name": "The Walking Dead: World Beyond",
            "popularity": 470.921,
            "origin_country": [
                "US"
            ],
            "vote_count": 344,
            "first_air_date": "2020-10-04",
            "backdrop_path": "/pLVrN9B750ehwTFdQ6n3HRUERLd.jpg",
            "original_language": "en",
            "id": 94305,
            "vote_average": 7.7,
            "overview": "A heroic group of teens sheltered from the dangers of the post-apocalyptic world receive a message that inspires them to leave the safety of the only home they have ever known and embark on a cross-country journey to find the one man who can possibly save the world.",
            "poster_path": "/z31GxpVgDsFAF4paZR8PRsiP16D.jpg"
        },
        {
            "original_name": "The Good Doctor",
            "genre_ids": [
                18
            ],
            "name": "The Good Doctor",
            "popularity": 695.587,
            "origin_country": [
                "US"
            ],
            "vote_count": 5359,
            "first_air_date": "2017-09-25",
            "backdrop_path": "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
            "original_language": "en",
            "id": 71712,
            "vote_average": 8.6,
            "overview": "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
            "poster_path": "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        },
        {
            "original_name": "Cobra Kai",
            "genre_ids": [
                18,
                10759
            ],
            "name": "Cobra Kai",
            "popularity": 413.425,
            "origin_country": [
                "US"
            ],
            "vote_count": 1047,
            "first_air_date": "2018-05-02",
            "backdrop_path": "/g63KmFgqkvXu6WKS23V56hqEidh.jpg",
            "original_language": "en",
            "id": 77169,
            "vote_average": 8,
            "overview": "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            "poster_path": "/eTMMU2rKpZRbo9ERytyhwatwAjz.jpg"
        },
        {
            "original_name": "Suburra - La serie",
            "genre_ids": [
                80,
                18
            ],
            "name": "Suburra: Blood on Rome",
            "popularity": 404.948,
            "origin_country": [
                "IT"
            ],
            "vote_count": 45,
            "first_air_date": "2017-10-06",
            "backdrop_path": "/2MLA8lpII4CVNQV7pYGyZRRip67.jpg",
            "original_language": "it",
            "id": 73671,
            "vote_average": 7.3,
            "overview": "In 2008, a fight over land in a seaside town near Rome spirals into a deadly battle between organized crime, corrupt politicians and the Vatican.",
            "poster_path": "/ri1WF0vxDfJcUW8iNUOu8OsmVeJ.jpg"
        },
        {
            "original_name": "Grey's Anatomy",
            "genre_ids": [
                18
            ],
            "name": "Grey's Anatomy",
            "popularity": 388.438,
            "origin_country": [
                "US"
            ],
            "vote_count": 3957,
            "first_air_date": "2005-03-27",
            "backdrop_path": "/3IIBf6VlwEyKAX4cN2XCM1gKdgM.jpg",
            "original_language": "en",
            "id": 1416,
            "vote_average": 8,
            "overview": "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "poster_path": "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
        },
        {
            "original_name": "The Simpsons",
            "genre_ids": [
                16,
                35,
                10751,
                18
            ],
            "name": "The Simpsons",
            "popularity": 353.648,
            "origin_country": [
                "US"
            ],
            "vote_count": 5092,
            "first_air_date": "1989-12-16",
            "backdrop_path": "/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg",
            "original_language": "en",
            "id": 456,
            "vote_average": 7.7,
            "overview": "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "poster_path": "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"
        },
        {
            "original_name": "Supernatural",
            "genre_ids": [
                18,
                9648,
                10765
            ],
            "name": "Supernatural",
            "popularity": 342.894,
            "origin_country": [
                "US"
            ],
            "vote_count": 4122,
            "first_air_date": "2005-09-13",
            "backdrop_path": "/nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg",
            "original_language": "en",
            "id": 1622,
            "vote_average": 8.1,
            "overview": "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
            "poster_path": "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        },
        {
            "original_name": "The Vampire Diaries",
            "genre_ids": [
                18,
                14,
                27,
                10749
            ],
            "name": "The Vampire Diaries",
            "popularity": 335.569,
            "origin_country": [
                "US"
            ],
            "vote_count": 3983,
            "first_air_date": "2009-09-10",
            "backdrop_path": "/k7T9xRyzP41wBVNyNeLmh8Ch7gD.jpg",
            "original_language": "en",
            "id": 18165,
            "vote_average": 8.3,
            "overview": "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
            "poster_path": "/aBkVgChtyyJaHyZh1gfd8DbzQon.jpg"
        },
        {
            "original_name": "The 100",
            "genre_ids": [
                18,
                10759,
                10765
            ],
            "name": "The 100",
            "popularity": 367.094,
            "origin_country": [
                "US"
            ],
            "vote_count": 4793,
            "first_air_date": "2014-03-19",
            "backdrop_path": "/hTExot1sfn7dHZjGrk0Aiwpntxt.jpg",
            "original_language": "en",
            "id": 48866,
            "vote_average": 7.8,
            "overview": "100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet — but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.",
            "poster_path": "/wcaDIAG1QdXQLRaj4vC1EFdBT2.jpg"
        },
        {
            "original_name": "Game of Thrones",
            "genre_ids": [
                10765,
                18,
                10759,
                9648
            ],
            "name": "Game of Thrones",
            "popularity": 350.322,
            "origin_country": [
                "US"
            ],
            "vote_count": 11246,
            "first_air_date": "2011-04-17",
            "backdrop_path": "/suopoADq0k8YZr4dQXcU6pToj6s.jpg",
            "original_language": "en",
            "id": 1399,
            "vote_average": 8.3,
            "overview": "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "poster_path": "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
        },
        {
            "original_name": "The Walking Dead",
            "genre_ids": [
                10759,
                18,
                10765
            ],
            "name": "The Walking Dead",
            "popularity": 336.625,
            "origin_country": [
                "US"
            ],
            "vote_count": 8441,
            "first_air_date": "2010-10-31",
            "backdrop_path": "/wXXaPMgrv96NkH8KD1TMdS2d7iq.jpg",
            "original_language": "en",
            "id": 1402,
            "vote_average": 7.9,
            "overview": "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "poster_path": "/qgjP2OrrX9gc6M270xdPnEmE9tC.jpg"
        },
        {
            "original_name": "The Umbrella Academy",
            "genre_ids": [
                10759,
                10765,
                35,
                18
            ],
            "name": "The Umbrella Academy",
            "popularity": 330.459,
            "origin_country": [
                "US"
            ],
            "vote_count": 3400,
            "first_air_date": "2019-02-15",
            "backdrop_path": "/qJxzjUjCpTPvDHldNnlbRC4OqEh.jpg",
            "original_language": "en",
            "id": 75006,
            "vote_average": 8.7,
            "overview": "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "poster_path": "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
        },
        {
            "original_name": "Riverdale",
            "genre_ids": [
                18,
                9648
            ],
            "name": "Riverdale",
            "popularity": 302.012,
            "origin_country": [
                "US"
            ],
            "vote_count": 6274,
            "first_air_date": "2017-01-26",
            "backdrop_path": "/9hvhGtcsGhQY58pukw8w55UEUbL.jpg",
            "original_language": "en",
            "id": 69050,
            "vote_average": 8.6,
            "overview": "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "poster_path": "/4X7o1ssOEvp4BFLim1AZmPNcYbU.jpg"
        },
        {
            "original_name": "I Am...",
            "genre_ids": [
                18
            ],
            "name": "I Am...",
            "popularity": 265.568,
            "origin_country": [],
            "vote_count": 4,
            "first_air_date": "2019-07-23",
            "backdrop_path": null,
            "original_language": "en",
            "id": 91605,
            "vote_average": 4.8,
            "overview": "Each hour-long film follows a different women as they experience “moments that are emotionally raw, thought-provoking and utterly personal”.",
            "poster_path": "/oogunE22HDTcTxFakKQbwqfw1qo.jpg"
        },
        {
            "original_name": "The Flash",
            "genre_ids": [
                18,
                10765
            ],
            "name": "The Flash",
            "popularity": 266.02,
            "origin_country": [
                "US"
            ],
            "vote_count": 6052,
            "first_air_date": "2014-10-07",
            "backdrop_path": "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
            "original_language": "en",
            "id": 60735,
            "vote_average": 7.5,
            "overview": "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "poster_path": "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
        }
    ]""".trimIndent()

  private val moviesData = """[
                {
                    "popularity": 2517.138,
                    "vote_count": 65,
                    "video": false,
                    "poster_path": "/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg",
                    "id": 724989,
                    "adult": false,
                    "backdrop_path": "/86L8wqGMDbwURPni2t7FQ0nDjsH.jpg",
                    "original_language": "en",
                    "original_title": "Hard Kill",
                    "genre_ids": [
                        28,
                        53
                    ],
                    "title": "Hard Kill",
                    "vote_average": 4.7,
                    "overview": "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.",
                    "release_date": "2020-10-23"
                },
                {
                    "popularity": 1768.318,
                    "vote_count": 486,
                    "video": false,
                    "poster_path": "/betExZlgK0l7CZ9CsCBVcwO1OjL.jpg",
                    "id": 531219,
                    "adult": false,
                    "backdrop_path": "/8rIoyM6zYXJNjzGseT3MRusMPWl.jpg",
                    "original_language": "en",
                    "original_title": "Roald Dahl's The Witches",
                    "genre_ids": [
                        14,
                        10751,
                        12,
                        35,
                        27
                    ],
                    "title": "Roald Dahl's The Witches",
                    "vote_average": 7.1,
                    "overview": "In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered.",
                    "release_date": "2020-10-26"
                },
                {
                    "popularity": 1601.355,
                    "vote_count": 247,
                    "video": false,
                    "poster_path": "/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg",
                    "id": 528085,
                    "adult": false,
                    "backdrop_path": "/5UkzNSOK561c2QRy2Zr4AkADzLT.jpg",
                    "original_language": "en",
                    "original_title": "2067",
                    "genre_ids": [
                        878,
                        53,
                        18
                    ],
                    "title": "2067",
                    "vote_average": 5.1,
                    "overview": "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.",
                    "release_date": "2020-10-01"
                },
                {
                    "popularity": 1071.169,
                    "vote_count": 87,
                    "video": false,
                    "poster_path": "/zfdhsR3Y3xw42OHrMpi0oBw0Uk8.jpg",
                    "id": 741074,
                    "adult": false,
                    "backdrop_path": "/DA7gzvlBoxMNL0XmGgTZOyv67P.jpg",
                    "original_language": "en",
                    "original_title": "Once Upon a Snowman",
                    "genre_ids": [
                        16,
                        35,
                        14,
                        10751
                    ],
                    "title": "Once Upon a Snowman",
                    "vote_average": 7.7,
                    "overview": "The previously untold origins of Olaf, the innocent and insightful, summer-loving snowman are revealed as we follow Olaf’s first steps as he comes to life and searches for his identity in the snowy mountains outside Arendelle.",
                    "release_date": "2020-10-23"
                },
                {
                    "popularity": 991.784,
                    "vote_count": 2413,
                    "video": false,
                    "poster_path": "/riYInlsq2kf1AWoGm80JQW5dLKp.jpg",
                    "id": 497582,
                    "adult": false,
                    "backdrop_path": "/kMe4TKMDNXTKptQPAdOF0oZHq3V.jpg",
                    "original_language": "en",
                    "original_title": "Enola Holmes",
                    "genre_ids": [
                        80,
                        18,
                        9648
                    ],
                    "title": "Enola Holmes",
                    "vote_average": 7.6,
                    "overview": "While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord.",
                    "release_date": "2020-09-23"
                },
                {
                    "popularity": 944.276,
                    "vote_count": 139,
                    "video": false,
                    "poster_path": "/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg",
                    "id": 741067,
                    "adult": false,
                    "backdrop_path": "/aO5ILS7qnqtFIprbJ40zla0jhpu.jpg",
                    "original_language": "en",
                    "original_title": "Welcome to Sudden Death",
                    "genre_ids": [
                        28,
                        53,
                        12,
                        18
                    ],
                    "title": "Welcome to Sudden Death",
                    "vote_average": 6.4,
                    "overview": "Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller.",
                    "release_date": "2020-09-29"
                },
                {
                    "popularity": 1418.971,
                    "vote_count": 34,
                    "video": false,
                    "poster_path": "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                    "id": 635302,
                    "adult": false,
                    "backdrop_path": "/xoqr4dMbRJnzuhsWDF3XNHQwJ9x.jpg",
                    "original_language": "ja",
                    "original_title": "劇場版「鬼滅の刃」無限列車編",
                    "genre_ids": [
                        16,
                        28,
                        36,
                        12,
                        14,
                        18
                    ],
                    "title": "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train",
                    "vote_average": 6.8,
                    "overview": "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                    "release_date": "2020-10-16"
                },
                {
                    "popularity": 896.903,
                    "vote_count": 261,
                    "video": false,
                    "poster_path": "/lQfdytwN7eh0tXWjIiMceFdBBvD.jpg",
                    "id": 560050,
                    "adult": false,
                    "backdrop_path": "/htBUhLSS7FfHtydgYxUWjL3J1Q1.jpg",
                    "original_language": "en",
                    "original_title": "Over the Moon",
                    "genre_ids": [
                        16,
                        12,
                        10751,
                        14
                    ],
                    "title": "Over the Moon",
                    "vote_average": 7.7,
                    "overview": "A girl builds a rocket to travel to the moon in hopes of meeting the legendary Moon Goddess.",
                    "release_date": "2020-10-16"
                },
                {
                    "popularity": 846.152,
                    "vote_count": 685,
                    "video": false,
                    "poster_path": "/6agKYU5IQFpuDyUYPu39w7UCRrJ.jpg",
                    "id": 740985,
                    "adult": false,
                    "backdrop_path": "/hbrXbVoE0NuA1ORoSGGYNASagrl.jpg",
                    "original_language": "en",
                    "original_title": "Borat Subsequent Moviefilm",
                    "genre_ids": [
                        35
                    ],
                    "title": "Borat Subsequent Moviefilm",
                    "vote_average": 6.7,
                    "overview": "14 years after making a film about his journey across the USA, Borat risks life and limb when he returns to the United States with his young daughter, and reveals more about the culture, the COVID-19 pandemic, and the political elections.",
                    "release_date": "2020-10-23"
                },
                {
                    "popularity": 520.621,
                    "vote_count": 12639,
                    "video": false,
                    "poster_path": "/gGEsBPAijhVUFoiNpgZXqRVWJt2.jpg",
                    "id": 354912,
                    "adult": false,
                    "backdrop_path": "/askg3SMvhqEl4OL52YuvdtY40Yb.jpg",
                    "original_language": "en",
                    "original_title": "Coco",
                    "genre_ids": [
                        16,
                        10751,
                        35,
                        12,
                        14,
                        10402
                    ],
                    "title": "Coco",
                    "vote_average": 8.2,
                    "overview": "Despite his family’s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.",
                    "release_date": "2017-10-27"
                },
                {
                    "popularity": 660.164,
                    "vote_count": 2745,
                    "video": false,
                    "poster_path": "/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
                    "id": 337401,
                    "adult": false,
                    "backdrop_path": "/zzWGRw277MNoCs3zhyG3YmYQsXv.jpg",
                    "original_language": "en",
                    "original_title": "Mulan",
                    "genre_ids": [
                        28,
                        12,
                        18,
                        14
                    ],
                    "title": "Mulan",
                    "vote_average": 7.2,
                    "overview": "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                    "release_date": "2020-09-04"
                },
                {
                    "popularity": 673.046,
                    "vote_count": 81,
                    "video": false,
                    "poster_path": "/xqbQtMffXwa3oprse4jiHBMBvdW.jpg",
                    "id": 601844,
                    "adult": false,
                    "backdrop_path": "/qTrpw2ZUvN7ywUu1kieEsvNDrgQ.jpg",
                    "original_language": "en",
                    "original_title": "Becky",
                    "genre_ids": [
                        53,
                        28,
                        27
                    ],
                    "title": "Becky",
                    "vote_average": 5.6,
                    "overview": "A teenager's weekend at a lake house with her father takes a turn for the worse when a group of convicts wreaks havoc on their lives.",
                    "release_date": "2020-07-23"
                },
                {
                    "popularity": 660.175,
                    "vote_count": 703,
                    "video": false,
                    "poster_path": "/sy6DvAu72kjoseZEjocnm2ZZ09i.jpg",
                    "id": 581392,
                    "adult": false,
                    "backdrop_path": "/2nFzxaAK7JIsk6l7qZ8rFBsa3yW.jpg",
                    "original_language": "ko",
                    "original_title": "반도",
                    "genre_ids": [
                        28,
                        27,
                        53
                    ],
                    "title": "Peninsula",
                    "vote_average": 7,
                    "overview": "A soldier and his team battle hordes of post-apocalyptic zombies in the wastelands of the Korean Peninsula.",
                    "release_date": "2020-07-15"
                },
                {
                    "popularity": 705.325,
                    "vote_count": 162,
                    "video": false,
                    "poster_path": "/6CoRTJTmijhBLJTUNoVSUNxZMEI.jpg",
                    "id": 694919,
                    "adult": false,
                    "backdrop_path": "/pq0JSpwyT2URytdFG0euztQPAyR.jpg",
                    "original_language": "en",
                    "original_title": "Money Plane",
                    "genre_ids": [
                        28
                    ],
                    "title": "Money Plane",
                    "vote_average": 5.9,
                    "overview": "A professional thief with ${'$'}40 million in debt and his family's life on the line must commit one final heist - rob a futuristic airborne casino filled with the world's most dangerous criminals.",
                    "release_date": "2020-09-29"
                },
                {
                    "popularity": 611.262,
                    "vote_count": 573,
                    "video": false,
                    "poster_path": "/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
                    "id": 539885,
                    "adult": false,
                    "backdrop_path": "/54yOImQgj8i85u9hxxnaIQBRUuo.jpg",
                    "original_language": "en",
                    "original_title": "Ava",
                    "genre_ids": [
                        28,
                        80,
                        18,
                        53
                    ],
                    "title": "Ava",
                    "vote_average": 5.8,
                    "overview": "A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.",
                    "release_date": "2020-07-02"
                },
                {
                    "popularity": 912.258,
                    "vote_count": 4,
                    "video": false,
                    "poster_path": "/j8D3jXHtA9cNb4epzvmA6hymKQ4.jpg",
                    "id": 499338,
                    "adult": false,
                    "backdrop_path": "/fUxq6ilPW01roOpqB5g9SOS3zZv.jpg",
                    "original_language": "en",
                    "original_title": "I Believe",
                    "genre_ids": [
                        10751
                    ],
                    "title": "I Believe",
                    "vote_average": 3.8,
                    "overview": "A 9 year old boy experiences God's power in a supernatural way.",
                    "release_date": "2020-11-05"
                },
                {
                    "popularity": 601.528,
                    "vote_count": 270,
                    "video": false,
                    "poster_path": "/r4Lm1XKP0VsTgHX4LG4syAwYA2I.jpg",
                    "id": 590223,
                    "adult": false,
                    "backdrop_path": "/lA5fOBqTOQBQ1s9lEYYPmNXoYLi.jpg",
                    "original_language": "en",
                    "original_title": "Love and Monsters",
                    "genre_ids": [
                        28,
                        12,
                        35,
                        878
                    ],
                    "title": "Love and Monsters",
                    "vote_average": 7.7,
                    "overview": "Seven years after the Monsterpocalypse, Joel Dawson, along with the rest of humanity, has been living underground ever since giant creatures took control of the land. After reconnecting over radio with his high school girlfriend Aimee, who is now 80 miles away at a coastal colony, Joel begins to fall for her again. As Joel realizes that there’s nothing left for him underground, he decides against all logic to venture out to Aimee, despite all the dangerous monsters that stand in his way.",
                    "release_date": "2020-10-16"
                },
                {
                    "popularity": 517.906,
                    "vote_count": 226,
                    "video": false,
                    "poster_path": "/vJHSParlylICnI7DuuI54nfTPRR.jpg",
                    "id": 438396,
                    "adult": false,
                    "backdrop_path": "/qGZe9qTuydxyJYQ60XDtEckzLR8.jpg",
                    "original_language": "es",
                    "original_title": "Orígenes secretos",
                    "genre_ids": [
                        18,
                        53
                    ],
                    "title": "Unknown Origins",
                    "vote_average": 6.2,
                    "overview": "In Madrid, Spain, a mysterious serial killer ruthlessly murders his victims by recreating the first appearance of several comic book superheroes. Cosme, a veteran police inspector who is about to retire, works on the case along with the tormented inspector David Valentín and his own son Jorge Elías, a nerdy young man who owns a comic book store.",
                    "release_date": "2020-08-28"
                },
                {
                    "popularity": 482.911,
                    "vote_count": 23,
                    "video": false,
                    "poster_path": "/z0r3YjyJSLqf6Hz0rbBAnEhNXQ7.jpg",
                    "id": 697064,
                    "adult": false,
                    "backdrop_path": "/7WKIOXJa2JjHygE8Yta3uaCv6GC.jpg",
                    "original_language": "en",
                    "original_title": "Beckman",
                    "genre_ids": [
                        28
                    ],
                    "title": "Beckman",
                    "vote_average": 5.5,
                    "overview": "A contract killer, becomes the reverend of a LA church, until a cult leader and his minions kidnap his daughter. Blinded by vengeance, he cuts a bloody path across the city. The only thing that can stop him is his newfound faith.",
                    "release_date": "2020-09-10"
                },
                {
                    "popularity": 527.368,
                    "vote_count": 125,
                    "video": false,
                    "poster_path": "/xqvX5A24dbIWaeYsMTxxKX5qOfz.jpg",
                    "id": 660982,
                    "adult": false,
                    "backdrop_path": "/75ooojtgiKYm5LcCczbCexioZze.jpg",
                    "original_language": "en",
                    "original_title": "American Pie Presents: Girls' Rules",
                    "genre_ids": [
                        35
                    ],
                    "title": "American Pie Presents: Girls Rules",
                    "vote_average": 6.2,
                    "overview": "It's Senior year at East Great Falls. Annie, Kayla, Michelle, and Stephanie decide to harness their girl power and band together to get what they want their last year of high school.",
                    "release_date": "2020-10-06"
                }
            ]""".trimIndent()

  private var gson = Gson()

  fun getTvs(): List<Tv> {
    return gson.fromJson(tvsData, Array<Tv>::class.java).toList()
  }

  fun getMovies(): List<Movie> {
    return gson.fromJson(moviesData, Array<Movie>::class.java)
      .toList()
  }
}