package com.example.hard_mad_2.data_stub

import androidx.compose.ui.text.toUpperCase
import com.example.hard_mad_2.models.AuthorModel
import com.example.hard_mad_2.models.BookChapter
import com.example.hard_mad_2.models.CarouselItem
import com.example.hard_mad_2.models.ChapterContent
import com.example.hard_mad_2.models.ChapterStatus
import com.example.hard_mad_2.models.GridItem
import com.example.hard_mad_2.models.SearchItem
import com.example.hard_mad_2.state.ReadingData
import java.util.Locale

object Data {
    val signInPics =
        listOf(
            "https://s3-alpha-sig.figma.com/img/6c14/f05b/ceec55a32a17da7a6043413eb5b90676?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=tXYC6en0LM1E3LVrzAONwU-v4pflVkcC32pEj1r~rVM6EHWaykmGAkFM-8VTjDHzN5OegfaS6gKae1t9MBGDaYRfdTZZO3eaJgNeoA-aNoe3x~jxHXr9lkd5Q97y~JEm6-5RB4Zm2pHTmB8F6sdks~-2u2KlsyTMYrRmir8Wc8L-eamhfRxidV-jlV~fOupkN7wKoyzvUsba4L5ydaBfneTXsfBlLYVH3VumNrIPAKvHWickzf5lNUGp8rWo99hIYNyIhp0EWycOlwvnFYlIWIeO8VitoLLyABu9QtAkfY6FuPMZ7bWZ4bGEQdohZln8w3b2oZuD0p95kz9Hb5shjQ__",
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "https://s3-alpha-sig.figma.com/img/c116/1776/f4ccba0316c0050e9df514629488db9c?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=GpeTiAC4JWFAvVuIQ~4B1hmElWjJ0YzOeRlf5rS~g8l~x3xEYR9L1d25Q0Amn3MilKGZEhsKe-spPdn4xueCosLzqSmj9DpbF~MJuVb9yujvh29Z7uIRczUdr0VsfCKgwErB3NC4tNGoalcMZan4PCEQ85pJCQK5Pbtp4jqFzEZRJ5pYkJlCAnN1BIGrCm2DBP3L0Sjk6rTcrC~GFVCZePx-M3UT4Koh-LxKr8ZSLFxA3Rk6sWkOvvJurkSn0iTfUqvS12ehhvUAVbDZyGxOlMRP3Sv55cT1Wn~z8qYbCZY330FpuoCD6mfZ8p2zfVQ33MTTpIKUKJ8U-8aIgBYm3w__"
        )

    val carouselList = listOf(
        CarouselItem(
            "https://s3-alpha-sig.figma.com/img/e78d/4d8b/3d14f7d2337f30cc395f60a722429361?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=n80sHidKhg5DneIB87Ep9aENljqmQAVL65rjcPa7dPDRWZoY6kASxgOTlBxK-0Y0Bqih9KfNOYbc9O6VHwvQoUrwp5PuT8-~LkU~3RH4~yBa0dxX6VbAsSitbvHRmhCWzjxzWcb5j~wbZyjp7PO4jqPjMx5TELgOxGR-Q5H9EO-iyQrp-dMGLm3C3ilDnJKFKJ8cpREx-K5HxxTnBygCXzsg-~qsE5aUIpYzL-MsJN7XyXdHLfsRw8DRPXLnqS18DFm~RScinxttjYcvIDwSQdVTFR8zGr7ZNkX~F~Zh2g9Hat-~sSPUynNrTcYuja4l~DZp~aTyvQ9tuQhiexPkog__",
            slogan = "Долгожданное продолжение «Голодных игр»",
            name = "рассвет жатвы".uppercase(
                Locale.ROOT
            )
        ),
        CarouselItem(
            "https://s3-alpha-sig.figma.com/img/2cc3/4f6f/0c56ae15405cf2accc46fca230ab0ff3?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=cAeo78Hdsvld7LnqfmdiXLrpEc50wCffmEea7imZlyiOLFws9x9qWmqTYGmS6ynQzkxKnpMPqMRewa1jUcah~Tnae5vUlD6dCzUI3TEcxO9A3jHkBDUa9Eb~E-Ro~Q9ZU-o758rkqeD7~11SjgyWfAI9FQMm~uc4wwombs9qsZ3xut7WcDwzy6c-ymXJ9Vrk4rKnZQWLIC1VOBbJrUePU2qZYWlfxitAJOn6S70RsCzP6vtxS7xYzxfUERpMoxpPGjiYfvpac-8OKOe1AzefU-dORGcYrU0qFlTnHUdp4u3M2kUym6I7CuyYp9Qom~5rPeWVDDoc-rgsicE-qPD7DQ__",
            slogan = "Долгожданное продолжение «Голодных игр»",
            name = "рассвет жатвы".uppercase(
                Locale.ROOT
            )
        ),
        CarouselItem(
            "https://s3-alpha-sig.figma.com/img/e2cc/8cb2/e6ff3ad7b4946fe185f45f74d2c8c2f1?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=pL0nZkx38-3iOqFueuU7SxiaOIS4wo~WPz8WdgQm-tE5uOpZg21Gu66WJ2DOKodkbeCRpmgJFYgaeHhfZ7wEvAynhccdI-jj0DoqIN-nyXSxkOr9QphnWmo3QbNuafbH8TCE1CxKng-4c76ZMQHZIhTBrfTBnk5e0udiY9p9d44IX~2i5cn0YTz3SdVxdc~uTiWOBb3VWhc8YeYd9FzAic84pN~FvnhEVXEQZQzDJlWuA7co0suOc3gheUSgU8WGM1YSJHvPV7pJpBrfjwNKs4XtTaqh1mjeCwZIegtXjE~-T8NEoqaxFpTXg34nPx6qvVCAtIYSK8nGP1wFmBWO7A__",
            slogan = "Долгожданное продолжение «Голодных игр»",
            name = "рассвет жатвы".uppercase(
                Locale.ROOT
            )
        )
    )
    val gridList = listOf(
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        ),
        GridItem(
            "https://s3-alpha-sig.figma.com/img/f257/a111/c2089fa3e8d2875ffd8e114f77cb69c6?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=gMLGhTITguoCykmBEY67HYPJOi5~acRcXIPBYmxb2wNd7WCiSwtJor9FohKqO4BEFvubO4ERIzSkEL3b47S6WfwBFHQk5HnqjbzgyvH0Y~QvMyrynKpT1Zvoi7FdSRnbeS4-OLBw0m7KRXBpJmrL~I5GlYbdIu205LYOYuG06zrVD8PZrtI8BHpCzAIJhR33CSIfuLYFSlxnquRTOJRx0sqPfjoDSqzCswBhp-Cx0ZXWABiYIZpzixbcjS924xbUEn~Y3QzydH7fvLtVVXVgCdV6vIJP4hlLsUHTsskrZ2tyZHkuRUSqHWWltd3sw28DJ-jgF2DkcPct1f8z9iTRGA__",
            "Понедельник начинается в субботу".uppercase(
                Locale.ROOT
            ),
            "Эрик Мария Ремарк"
        )
    )
    val searchItems = mutableListOf(
        SearchItem(
            img = "https://imo10.labirint.ru/books/626058/cover.jpg/484-0",
            name = "SWift для детей",
            authors = listOf("Мэтт Маккарти", "Глория Уинквист")
        ),
        SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/7ede/77d4/132cdb792fea35ca627c2fee4ab18cf7?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=FHRLAistDthj8wZmTN7e6HQJrRoBnZ3Ttc5llplTM5s~8W0~uOwXx8Bgjp6t0VSjzuj5~2FDH4IKBp-ftb4eo0ZzAT1C478~P-OfNG9KJL5fWvgRi49xiJmY-aG4LcDyfxap-9ADuFCgESHSEMqsVYUUULpgKZJk6g0rkbialwR5hwYH42EOEwUD0S~20Z~0IvCGhxxrhnTmNx-fpDZaPXXJn1sWVdrgJVPHSJTf4RL4zLZHJ~ZZjmz9COiBflMvx4F9ZcePsLdxt3h9kkpmbb-sSr6QWsUf8JsXhPoEQjyIVD4UC-tCHMb8sH3NQ1gFo6v7lHW9MlyX3ILVb9T4aA__",
            name = "Чистый код: создание, анализ и рефакторинг",
            authors = listOf("Роберт Мартин")
        ),
        /*SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/ba32/f5b4/3e6bebdca2ddfdcc9982a23afbb2ad2e?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NlsktxrcZN0KDLBLPATSSHL~ClO99WwzvkyvOHDZ~1OM~SOtoyv0bcg2hL8OTWDN1t8-YfigCSC8qEOH2KtQdduKUMAG1mqsevnLDZm7txLVdHsG0k8FmteCS1G1fSpP76~JECTTEvjJU-MPBEXhTTQHDj3922GeN0LY2peI~LZG5B8tMDYZi3W58ErWNiswJmxYtT1h7xaWvh9o~rUqGEhy5xzaY7K6cfs3IF-xtHT~WOBfUmnuZrxI8r44C4QJ~IQ5BrUjvXKaXgkGSAkJTzEayRQ3gloQj2kpYFBYlLg-EOkA9zXiJFOvZvFCGrEEjKT8doLBQPVz9i~RjA24lA__",
            name = "Kotlin в действии",
            authors = listOf("Дмитрий Жемеров", "Светлана Исакова")
        )*/
    )
    val genres = listOf(
        "Классика",
        "Фэнтези",
        "Фантастика",
        "Детектив",
        "Триллер",
        "Исторический роман",
        "Любовный роман",
        "Приключения"
    )
    val authors = listOf(
        AuthorModel(
            image = "https://s3-alpha-sig.figma.com/img/554e/d976/58713175fa8334c8e0318b7bcf1ca253?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=AYRPfkq1hNsMjBhS64OHizrFItoY47-wurtW2hlQ3jzlIobixITGHzF-9CojEkr5aD21XAOHWtHqswbSnuNSe~b8XT9S-7Yv8L-~eiKJBGISYyPLbsPvQXcd-Ho1labFhHNiKBdWsRPmPrj0RQ~NLX7b4j1Q1gxU5zaO6nQnn1l~uxCPIwdYqIxc2u6YOHCVXzjFroF~4Vvhyv3MXXNi2kOSpAP02z2sKLg6qyWaQ5ScwXOIRUZmz2B-LbVACguYjOZqMuCNxfhH8gwju2ehU0N3k~0X2py~1DN0XgHGWn10he-2Fai3pr7Ye2mC25wNJSE5NHA1cAdtN7q3rlW3iA__",
            "Братья Стругацкие"
        ),
        AuthorModel(
            image = "https://s3-alpha-sig.figma.com/img/fc2f/2f1c/898bdf2cb5cf0120237adce81ea30a40?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=RX99mYMrMD15y4c7zcS0ggXjBzvNdxjESD27Fdsq~YLYU9317BX8HT5LPQsB2NvsDYTEVaS-DDKnlJy7NBCLAQva4GA8-rWl547uN18iLwifga~1kqU3APuuVY-zTEck8HIyNLb~IAuKF~q-swjKywJeqyQV4VN73YuWtr~y8-EplHSdzwiX2~wePFYBLhYo5jBriVrEFUBhLjswyegmb4ZHVWb60Mu5FraJPneaDewIXJAvRPzUWeV821lVnBEWYodtMuT6RbJnoLW~-th8g~z849ECIa~QFI-Zjq3VRoyUxthR~759vn1PbS49tgF4tow-8aNhFYy-nMc-LlRyjA__",
            "Дэн Браун"
        ),
        AuthorModel(
            image = "https://s3-alpha-sig.figma.com/img/27ac/1236/e42171078cc8fc2da12e831785130c99?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=uGEBLzwF3dG2CVExgsLQTwqKHPON9ItZrklRbujxxZPLsXPsl~M1PzMso~9vLPZmXuUx8A6ac2v9OFbI5u2BLc4SWSW7FctHPNZCgiX7S5Hh-nnzcNU~moqHLwg-77YPuVrU3B2BZrak9SP7SmSBcdFAKSrZ6XgOwe43p4b9szpzN8RUI0772H9Kn~Alr0Bfy0dmyhAupOxiyTPSRe7oU5CqoExO1sP8thhUC6f5rI-GJKVlnFuR1RjPR49DSqv-7kcHcVb-ykPoOntV3JFRV1GmNzIGTAXTVcJaRFve85OohL-vPFHDzZnyXGCzfr2ceef2wMRaNGxK0A7kzXaiLw__",
            "Федор Достоевский"
        )
    )
    val readingBook = SearchItem(
        img = "https://s3-alpha-sig.figma.com/img/6c14/f05b/ceec55a32a17da7a6043413eb5b90676?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=tXYC6en0LM1E3LVrzAONwU-v4pflVkcC32pEj1r~rVM6EHWaykmGAkFM-8VTjDHzN5OegfaS6gKae1t9MBGDaYRfdTZZO3eaJgNeoA-aNoe3x~jxHXr9lkd5Q97y~JEm6-5RB4Zm2pHTmB8F6sdks~-2u2KlsyTMYrRmir8Wc8L-eamhfRxidV-jlV~fOupkN7wKoyzvUsba4L5ydaBfneTXsfBlLYVH3VumNrIPAKvHWickzf5lNUGp8rWo99hIYNyIhp0EWycOlwvnFYlIWIeO8VitoLLyABu9QtAkfY6FuPMZ7bWZ4bGEQdohZln8w3b2oZuD0p95kz9Hb5shjQ__",
        name = "Код да винчи".toUpperCase(
            androidx.compose.ui.text.intl.Locale.current
        ),
        authors = listOf("Дэн Браун"),
        description = "Секретный код скрыт в работах Леонардо да Винчи...\n" +
                "Только он поможет найти христианские святыни, дающие немыслимые власть и могущество... \n" +
                "Ключ к величайшей тайне, над которой человечество билось веками, наконец может быть найден..."
    )
    val currentBookData = ReadingData(isReading = true, chapter = "Пролог", progress = 10)

    val bookChapters = listOf(
        BookChapter(name = "Факты", chapterStatus = ChapterStatus.ALREADY_READ),
        BookChapter(name = "Пролог", chapterStatus = ChapterStatus.READING_NOW),
        BookChapter(name = "Глава 1", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 2", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 3", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 4", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 5", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 6", chapterStatus = ChapterStatus.NOT_STARTED),
        BookChapter(name = "Глава 7", chapterStatus = ChapterStatus.NOT_STARTED),
    )
    val bookDetailsPreview =
        "https://s3-alpha-sig.figma.com/img/e11b/cb67/f5e3dc5e3a35431158e3ccca0bd40b5b?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NQfOYlq34HRq32ftA7l1I-Tdd~htEktlLHbe65jxe8LH52aGpj3TPA~SjnzRa22jXBOLlZntcTruX40udq9xp04GPgLZGgsr6YQ6fOO-YWAzfWaacmsHPt-Vjw~2bfw-2YighWpBsfvc5oHNxib4I947zBcLEQxRveribhFw-ZvU06FZ2jf7msdDTnpcDzAkwyJvcJ-aFPcRCDTR~thlfUOVyc69Iu4WHHKP0cHag87ASZv1SrG2cXjjoB9N7cjudcH5iql39HedvRw8cD9j-KEowWTXkvaUnfR6vT4RRF5kcMXVef202Z-IjFM8zypU9WtI1cb9OABFvt2VMwTMJw__"
    val bookContent = listOf(
        "Факты",
        "Пролог",
        "Глава 1",
        "Глава 2",
        "Глава 3",
        "Глава 4",
        "Глава 5",
        "Глава 6",
        "Глава 7",
        "Глава 8",
        "Глава 9",
        "Глава 10",
        "Глава 11",
        "Глава 12",
        "Глава 13",
    )

    val recentRequest = listOf("iOS", "Android")

    val quotes = listOf(
        "Я все еще жив",
        "Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
                "белыми волосами"
    )
    val prologue = "*Париж, Лувр\n21.46\n" +
            "Знаменитый куратор Жак Соньер, пошатыва\u0002ясь, прошел под сводчатой аркой Большой га\u0002лереи и устремился к первой попавшейся ему" +
            "на глаза картине, полотну Караваджо. Ухватил\u0002ся руками за позолоченную раму и стал тянуть" +
            "ее на себя, пока шедевр не сорвался со стены и" +
            "не рухнул на семидесятилетнего старика Соньера, погребя его под собой.\n" +
            "Как и предполагал Соньер, неподалеку с грохотом опустилась" +
            "металлическая решетка, преграждающая доступ в этот зал. Пар\u0002кетный пол содрогнулся. Где-то завыла сирена игнализации.\n" +
            "Несколько секунд куратор лежал неподвижно, хватая ртом" +
            "воздух и пытаясь сообразить, на каком свете находится. Я все еще жив. Потом он выполз из-под полотна и начал судорожно ози\u0002раться в поисках места, где можно спрятаться.\n" +
            "Голос прозвучал неожиданно близко:\n" +
            "— Не двигаться.\n" +
            "Стоявший на четвереньках куратор похолодел, потом медлен\u0002но обернулся. Всего в пятнадцати футах от него, за решеткой, высилась внушительная и грозная фигура его преследователя. Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
            "белыми волосами. Белки розовые, а зрачки угрожающего темно\u0002красного цвета. Альбинос достал из кармана пистолет, сунул\n" +
            "длинный ствол в отверстие между железными прутьями и при\u0002целился в куратора.\n*"

    val secondChapter = "Краснокаменск, Лувр\u202821.46\n" +
            "Знаменитый куратор Жак Соньер, пошатыва\u0002ясь, прошел под сводчатой аркой Большой га\u0002лереи и устремился к первой попавшейся ему" +
            "на глаза картине, полотну Караваджо. Ухватил\u0002ся руками за позолоченную раму и стал тянуть" +
            "ее на себя, пока шедевр не сорвался со стены и" +
            "не рухнул на семидесятилетнего старика Соньера, погребя его под собой.\n" +
            "Как и предполагал Соньер, неподалеку с грохотом опустилась" +
            "металлическая решетка, преграждающая доступ в этот зал. Пар\u0002кетный пол содрогнулся. Где-то завыла сирена игнализации.\n" +
            "Несколько секунд куратор лежал неподвижно, хватая ртом" +
            "воздух и пытаясь сообразить, на каком свете находится. Я все еще жив. Потом он выполз из-под полотна и начал судорожно ози\u0002раться в поисках места, где можно спрятаться.\n" +
            "Голос прозвучал неожиданно близко:\n" +
            "— Не двигаться.\n" +
            "Стоявший на четвереньках куратор похолодел, потом медлен\u0002но обернулся. Всего в пятнадцати футах от него, за решеткой, высилась внушительная и грозная фигура его преследователя. Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
            "белыми волосами. Белки розовые, а зрачки угрожающего темно\u0002красного цвета. Альбинос достал из кармана пистолет, сунул\n" +
            "длинный ствол в отверстие между железными прутьями и при\u0002целился в куратора.\n"

    val firstChapter = "Краснокаменск, Лувр\u202821.46\n" +
            "Знаменитый куратор Жак Соньер, пошатыва\u0002ясь, прошел под сводчатой аркой Большой га\u0002лереи и устремился к первой попавшейся ему" +
            "на глаза картине, полотну Караваджо. Ухватил\u0002ся руками за позолоченную раму и стал тянуть" +
            "ее на себя, пока шедевр не сорвался со стены и" +
            "не рухнул на семидесятилетнего старика Соньера, погребя его под собой.\n" +
            "Как и предполагал Соньер, неподалеку с грохотом опустилась" +
            "металлическая решетка, преграждающая доступ в этот зал. Пар\u0002кетный пол содрогнулся. Где-то завыла сирена игнализации.\n" +
            "Несколько секунд куратор лежал неподвижно, хватая ртом" +
            "воздух и пытаясь сообразить, на каком свете находится. Я все еще жив. Потом он выполз из-под полотна и начал судорожно ози\u0002раться в поисках места, где можно спрятаться.\n" +
            "Голос прозвучал неожиданно близко:\n" +
            "— Не двигаться.\n" +
            "Стоявший на четвереньках куратор похолодел, потом медлен\u0002но обернулся. Всего в пятнадцати футах от него, за решеткой, высилась внушительная и грозная фигура его преследователя. Вы\u0002сокий, широкоплечий, с мертвенно-бледной кожей и редкими\n" +
            "белыми волосами. Белки розовые, а зрачки угрожающего темно\u0002красного цвета. Альбинос достал из кармана пистолет, сунул\n" +
            "длинный ствол в отверстие между железными прутьями и при\u0002целился в куратора.\n"


    val chapters = listOf(
        ChapterContent(
            name = "Пролог",
            number = 0,
            content = prologue
        ),
        ChapterContent(
            name = "Глава 1",
            number = 1,
            content = firstChapter
        ),
        ChapterContent(
            name = "Глава 2",
            number = 2,
            content = secondChapter
        ),
        ChapterContent(
            name = "Глава 3",
            number = 3,
            content = secondChapter
        ),
        ChapterContent(
            name = "Глава 4",
            number = 4,
            content = secondChapter
        ),
        ChapterContent(
            name = "Глава 5",
            number = 5,
            content = secondChapter
        ),
        ChapterContent(
            name = "Глава 6",
            number = 6,
            content = secondChapter
        ),
        ChapterContent(
            name = "Глава 7",
            number = 7,
            content = secondChapter
        ),
    )
}

