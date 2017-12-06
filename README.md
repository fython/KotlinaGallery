KotlinaGallery
====

[English translation (Not ready yet)]()

> Kotlin 在 1.2.0 中正式推出了跨平台共享代码（JVM/JS），能让开发者构建一个公共模块后同时投入到
> 前端、后端以及 Android 应用开发中（甚至可以借助 Kotlin Native 在 iOS 开发上使用）。

## 项目介绍

本项目使用 Kotlin 1.2 语言制作一个简单的 ACG 壁纸图库，其公共代码部分可由多个平台共用。

数据拉取自 [Konachan API](https://konachan.net/help/api)，该网站可能存在 NSFW 内容，建议使用时仅显示 `rating:s` 标签的图片。

Android 版已完成简单的最新壁纸列表演示，JS 模块尚未投入使用。

## 模块解释

![Multiplatform Project](/doc/MPP.png)

本项目公用部分在 `konachan-common` 模块中，其中使用了 kotlinx.serialization 和 kotlin.test 这两个支持跨平台的库~~（毕竟是官方的）~~。

### `konachan-common` module

声明 API 可用方法接口（`expect`）；定义返回的数据模型。

### `konachan-common-js` module

依赖 `konachan-common` 模块，完成 API 可用方法在 JavaScript 平台下的实现（`actual`）

### `konachan-common-jvm` module

依赖 `konachan-common` 模块，完成 API 可用方法在 JVM 虚拟机平台下的实现（`actual`）

### `konachan-android` module

依赖 `konachan-common-jvm` 模块，在 Android 平台下调用 API 实现 ACG 壁纸图库应用程序。

运用 Data Binding + MVVM 模式构建应用，界面风格贴近 Material Design 设计。

## 编译环境

- Android Studio 3.0 + Kotlin 1.2.0 Plugin（Android Gradle Plugin 的缘故，尚不支持 IntelliJ IDEA，有待官方解决）
- Gradle 4.3
- JDK 1.8+

## 参考

- Kotlin 1.2 正式版新闻：[Kotlin 1.2 is Released](https://blog.jetbrains.com/kotlin/2017/11/kotlin-1-2-released/)
- KotlinConf 官方项目演示：[JetBrains/kotlinconf-app](https://github.com/JetBrains/kotlinconf-app)
- Kotlin 跨平台项目参考：[Multiplatform Projects](https://kotlinlang.org/docs/reference/multiplatform.html)

## 联系作者

Telegram: [@fython](https://t.me/fython)

Email: fythonx@gmail.com

我的 Android 开发交流群：[Telegram](https://t.me/joinchat/BmgWUg7jjXlOCdZV-r6ivw)

捐赠支持（支付宝）：fythonx@gmail.com

## 协议

```
MIT License

Copyright (c) 2017 Fung Gwo (fython)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
