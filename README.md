### Hexlet tests and linter status:
[![Actions Status](https://github.com/Turich79/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Turich79/java-project-71/actions)

[![Maintainability](https://api.codeclimate.com/v1/badges/ee99a9660e1db9665a52/maintainability)](https://codeclimate.com/github/Turich79/java-project-71/maintainability)

[![Test Coverage](https://api.codeclimate.com/v1/badges/ee99a9660e1db9665a52/test_coverage)](https://codeclimate.com/github/Turich79/java-project-71/test_coverage)

# Differ
Differ - это утилита командной строки, которая сравнивает два файла конфигурации и показывает различия между ними.

## Использование

Для использования утилиты необходимо выполнить следующие команды:

* ./build/install/app/bin/app file1.json file2.json
* ./build/install/app/bin/app file1.yml file2.yml
* ./build/install/app/bin/app -f plain file1.json file2.json
* ./build/install/app/bin/app -f json file1.json file2.json

### где:

*filepath1* - путь к первому файлу конфигурации.

*filepath2* - путь ко второму файлу конфигурации.

### Опции
* -f, --format * - формат вывода различий. По умолчанию используется stylish.

## Форматы вывода
*stylish* - вывод в виде стилизованной таблицы.

*plain* - вывод в виде простого списка различий.

*json* - вывод в формате JSON.

## Пример работы утилиты
https://asciinema.org/a/E8rmnjednGJl8W1OgCjzc1HyZ
