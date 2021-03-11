package com.example.mpandroidchart.model


data class Catalog(
    var catalogType: String = "",
    var title: String = "",
    var percentage: Float = 0f,
    var investedValue: InvestedInfo,
    var netIncome: LabelValue,
    var color: String = ""
)

data class LabelValue(
    var label: String = "",
    var value: String = "",
    var footer: String = ""
)

data class TitleText(
    var title: String = "",
    var text: String = ""
)

data class Wallet(
    var title: String = "",
    var quantity: Int = 0,
    var lastUpdate: String = "",
    var products: List<ProductInfo>
)

data class ProductInfo(
    var id: String = "",
    var title: String = "",
    var subtitle: String = "",
    var hasFgc: Boolean,
    var grossValue: LabelValue,
    var details: List<LabelValue>,
    val button: ButtonValue
)

data class ButtonValue(
    var text: String = "",
    var enabled: Boolean
)

data class InvestedInfo(
    var labelValue: LabelValue,
    var titleText: TitleText
)

data class CatalogInfo(
    var catalog: Catalog,
    var wallet: Wallet,
    var button: ButtonValue
)




