package com.example.hard_mad_2.data_stub

import com.example.hard_mad_2.models.CarouselItem
import com.example.hard_mad_2.models.GridItem
import com.example.hard_mad_2.models.SearchItem
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
    val searchItems = listOf(
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
        SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/ba32/f5b4/3e6bebdca2ddfdcc9982a23afbb2ad2e?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NlsktxrcZN0KDLBLPATSSHL~ClO99WwzvkyvOHDZ~1OM~SOtoyv0bcg2hL8OTWDN1t8-YfigCSC8qEOH2KtQdduKUMAG1mqsevnLDZm7txLVdHsG0k8FmteCS1G1fSpP76~JECTTEvjJU-MPBEXhTTQHDj3922GeN0LY2peI~LZG5B8tMDYZi3W58ErWNiswJmxYtT1h7xaWvh9o~rUqGEhy5xzaY7K6cfs3IF-xtHT~WOBfUmnuZrxI8r44C4QJ~IQ5BrUjvXKaXgkGSAkJTzEayRQ3gloQj2kpYFBYlLg-EOkA9zXiJFOvZvFCGrEEjKT8doLBQPVz9i~RjA24lA__",
            name = "Kotlin в действии",
            authors = listOf("Дмитрий Жемеров", "Светлана Исакова")
        ),
        SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/ba32/f5b4/3e6bebdca2ddfdcc9982a23afbb2ad2e?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NlsktxrcZN0KDLBLPATSSHL~ClO99WwzvkyvOHDZ~1OM~SOtoyv0bcg2hL8OTWDN1t8-YfigCSC8qEOH2KtQdduKUMAG1mqsevnLDZm7txLVdHsG0k8FmteCS1G1fSpP76~JECTTEvjJU-MPBEXhTTQHDj3922GeN0LY2peI~LZG5B8tMDYZi3W58ErWNiswJmxYtT1h7xaWvh9o~rUqGEhy5xzaY7K6cfs3IF-xtHT~WOBfUmnuZrxI8r44C4QJ~IQ5BrUjvXKaXgkGSAkJTzEayRQ3gloQj2kpYFBYlLg-EOkA9zXiJFOvZvFCGrEEjKT8doLBQPVz9i~RjA24lA__",
            name = "Kotlin в действии",
            authors = listOf("Дмитрий Жемеров", "Светлана Исакова")
        ),
        SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/ba32/f5b4/3e6bebdca2ddfdcc9982a23afbb2ad2e?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NlsktxrcZN0KDLBLPATSSHL~ClO99WwzvkyvOHDZ~1OM~SOtoyv0bcg2hL8OTWDN1t8-YfigCSC8qEOH2KtQdduKUMAG1mqsevnLDZm7txLVdHsG0k8FmteCS1G1fSpP76~JECTTEvjJU-MPBEXhTTQHDj3922GeN0LY2peI~LZG5B8tMDYZi3W58ErWNiswJmxYtT1h7xaWvh9o~rUqGEhy5xzaY7K6cfs3IF-xtHT~WOBfUmnuZrxI8r44C4QJ~IQ5BrUjvXKaXgkGSAkJTzEayRQ3gloQj2kpYFBYlLg-EOkA9zXiJFOvZvFCGrEEjKT8doLBQPVz9i~RjA24lA__",
            name = "Kotlin в действии",
            authors = listOf("Дмитрий Жемеров", "Светлана Исакова")
        ),
        SearchItem(
            img = "https://s3-alpha-sig.figma.com/img/ba32/f5b4/3e6bebdca2ddfdcc9982a23afbb2ad2e?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=NlsktxrcZN0KDLBLPATSSHL~ClO99WwzvkyvOHDZ~1OM~SOtoyv0bcg2hL8OTWDN1t8-YfigCSC8qEOH2KtQdduKUMAG1mqsevnLDZm7txLVdHsG0k8FmteCS1G1fSpP76~JECTTEvjJU-MPBEXhTTQHDj3922GeN0LY2peI~LZG5B8tMDYZi3W58ErWNiswJmxYtT1h7xaWvh9o~rUqGEhy5xzaY7K6cfs3IF-xtHT~WOBfUmnuZrxI8r44C4QJ~IQ5BrUjvXKaXgkGSAkJTzEayRQ3gloQj2kpYFBYlLg-EOkA9zXiJFOvZvFCGrEEjKT8doLBQPVz9i~RjA24lA__",
            name = "Kotlin в действии",
            authors = listOf("Дмитрий Жемеров", "Светлана Исакова")
        )
    )
}

