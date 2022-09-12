<div align="center">

[![GitHub](https://img.shields.io/badge/--181717?logo=github&logoColor=ffffff)](https://github.com/)
[![Unlicense](https://img.shields.io/badge/License-Unlicense-blue.svg)](https://unlicense.org/)
[![Maintenance](https://img.shields.io/badge/maintained-no-red.svg)](https://bitbucket.org/lbesson/ansi-colors)

![logo](https://i.imgur.com/F46zO5F.png)

#### 🍰 A simple CLI password generator written in Java 🍰

</div>

</br>

## Table Of Contents

---

- [Install](#install)

- [Usage](#usage)

- [License](#license)

## Install

---

```bash
git clone https://github.com/chr3st5an/passwordgen && cd ./passwordgen/
```

## Usage

---

```bash
java -cp passwordgen-1.0.jar com.passwordgen.App length [OPTIONS]
```

This will generate a password with the given length. By default the password only consists of lower- and uppercase characters.

## Options

---

- `-d` include digits
- `-p` include punctuations characters
- `-e` show the passwords entropy

## License

---

This project is released into the public domain. Feel free to do anything you want to do.
