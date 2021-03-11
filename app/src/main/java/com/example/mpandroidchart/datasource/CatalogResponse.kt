package com.example.mpandroidchart.datasource

import com.example.mpandroidchart.model.*

object CatalogResponse {
    val catalogInfo: CatalogInfo =
        CatalogInfo(
            catalog = Catalog(
                catalogType = "FIXED_INCOME",
                title = "Renda fixa",
                percentage = 40.0F,
                investedValue = InvestedInfo(
                    LabelValue(label = "Valor investido", value = "R$ 5.940,60"),
                    TitleText(title = "Testando isso aqui", text = "É só para testar mininu")
                ),
                netIncome = LabelValue(
                    label = "Rendimento líquido", value = "R$ 81,64"
                ),
                color = "#00B99B"
            ),
            wallet = Wallet(
                title = "Meus Produtos",
                quantity = 3,
                lastUpdate = "Atualizado em: 09/02 - 18h33",
                products = arrayListOf(
                    ProductInfo(
                        id = "b4478052-95e8-4051-b50e-3765f055de96",
                        title = "CDB PagBank",
                        subtitle = "Banco Seguro",
                        hasFgc = false,
                        grossValue = LabelValue(label = "Valor bruto", value = "R$ 5.940,60"),
                        details = arrayListOf(
                            LabelValue(label = "Rentabilidade", value = "175% o CDI"),
                            LabelValue(
                                label = "Rentabilidade",
                                value = "23,26%",
                                footer = "últimos 12 meses"
                            ),
                            LabelValue(label = "Preço Fechamento", value = "R$ 20,17"),
                            LabelValue(label = "Quantidade de ações", value = "180")
                        ),
                        button = ButtonValue("VER DETALHES", enabled = true)
                    ), ProductInfo(
                        id = "b4478052-95e8-4051-b50e-3765f055de96",
                        title = "CDB PagBank",
                        subtitle = "Banco Seguro",
                        hasFgc = false,
                        grossValue = LabelValue(label = "Valor bruto", value = "R$ 5.940,60"),
                        details = arrayListOf(
                            LabelValue(label = "Rentabilidade", value = "175% o CDI"),
                            LabelValue(
                                label = "Rentabilidade",
                                value = "23,26%",
                                footer = "últimos 12 meses"
                            ),
                            LabelValue(label = "Preço Fechamento", value = "R$ 20,17"),
                            LabelValue(label = "Quantidade de ações", value = "180")
                        ),
                        button = ButtonValue("VER DETALHES", enabled = true)
                    ), ProductInfo(
                        id = "b4478052-95e8-4051-b50e-3765f055de96",
                        title = "CDB PagBank",
                        subtitle = "Banco Seguro",
                        hasFgc = false,
                        grossValue = LabelValue(label = "Valor bruto", value = "R$ 5.940,60"),
                        details = arrayListOf(
                            LabelValue(label = "Rentabilidade", value = "175% o CDI"),
                            LabelValue(
                                label = "Rentabilidade",
                                value = "23,26%",
                                footer = "últimos 12 meses"
                            ),
                            LabelValue(label = "Preço Fechamento", value = "R$ 20,17"),
                            LabelValue(label = "Quantidade de ações", value = "180")
                        ),
                        button = ButtonValue("VER DETALHES", enabled = true)
                    ), ProductInfo(
                        id = "b4478052-95e8-4051-b50e-3765f055de96",
                        title = "CDB PagBank",
                        subtitle = "Banco Seguro",
                        hasFgc = false,
                        grossValue = LabelValue(label = "Valor bruto", value = "R$ 5.940,60"),
                        details = arrayListOf(
                            LabelValue(label = "Rentabilidade", value = "175% o CDI"),
                            LabelValue(
                                label = "Rentabilidade",
                                value = "23,26%",
                                footer = "últimos 12 meses"
                            ),
                            LabelValue(label = "Preço Fechamento", value = "R$ 20,17"),
                            LabelValue(label = "Quantidade de ações", value = "180")
                        ),
                        button = ButtonValue("VER DETALHES", enabled = true)
                    ), ProductInfo(
                        id = "b4478052-95e8-4051-b50e-3765f055de96",
                        title = "CDB PagBank",
                        subtitle = "Banco Seguro",
                        hasFgc = false,
                        grossValue = LabelValue(label = "Valor bruto", value = "R$ 5.940,60"),
                        details = arrayListOf(
                            LabelValue(label = "Rentabilidade", value = "175% o CDI"),
                            LabelValue(
                                label = "Rentabilidade",
                                value = "23,26%",
                                footer = "últimos 12 meses"
                            ),
                            LabelValue(label = "Preço Fechamento", value = "R$ 20,17"),
                            LabelValue(label = "Quantidade de ações", value = "180")
                        ),
                        button = ButtonValue("VER DETALHES", enabled = true)
                    )
                )
            ),
            button = ButtonValue("INVESTIR", enabled = true)
        )
}

