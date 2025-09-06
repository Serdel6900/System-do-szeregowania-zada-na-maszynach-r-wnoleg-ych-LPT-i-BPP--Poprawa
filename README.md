# System do szeregowania zadań na maszynach równoległych (LPT i BPP)

## Autor
**Bartłomiej Sereda**  
Uniwersytet Rzeszowski  
Informatyka i Ekonometria  
Rok akademicki: 2024/2025

## Opis projektu
Aplikacja konsolowa napisana w Javie implementująca algorytmy szeregowania zadań (LPT - Longest Processing Time i BPP - Bin Packing Problem) na maszynach równoległych. System umożliwia optymalne przydzielanie zadań do maszyn z uwzględnieniem czasu wykonania i obciążenia, minimalizując zarówno maksymalne obciążenie maszyn (makespan) jak i liczbę wykorzystanych maszyn.

## Funkcjonalności
-  Dodawanie i zarządzanie zadaniami z walidacją danych
-  Tworzenie i konfiguracja maszyn równoległych
- Implementacja algorytmów LPT i BPP
-  Wizualizacja wyników szeregowania
-  Przechowywanie danych w pamięci aplikacji
-  Pełna obsługa wyjątków i walidacja danych

## Struktura aplikacji

### Klasy główne
- **`Main`** - klasa startowa uruchamiająca aplikację
- **`TaskSchedulerApp`** - główna klasa z interfejsem użytkownika i logiką zarządzania
- **`Task`** - klasa reprezentująca zadanie (nazwa, czas wykonania z walidacją)
- **`Machine`** - klasa reprezentująca maszynę z listą przypisanych zadań

### Algorytmy szeregowania
- **`Scheduler`** (abstrakcyjna) - bazowa klasa dla algorytmów szeregowania
- **`LPTScheduler`** - implementacja algorytmu Longest Processing Time
- **`BPPScheduler`** - implementacja algorytmu Bin Packing Problem

## Zaimplementowane algorytmy

### LPT (Longest Processing Time)
1. Sortuje zadania malejąco według czasu wykonania
2. Przydziela zadania do maszyn z najmniejszym aktualnym obciążeniem
3. Minimalizuje maksymalne obciążenie (makespan)
4. Zapewnia optymalne wykorzystanie zasobów

### BPP (Bin Packing Problem)
1. Sortuje zadania malejąco według czasu wykonania
2. Pakuje zadania do maszyn z uwzględnieniem maksymalnego obciążenia
3. Minimalizuje liczbę użytych maszyn
4. Rozwiązuje problem pakowania do ograniczonej liczby pojemników

## Instrukcja uruchomienia

### Wymagania
- Java 17 lub nowsza
- Środowisko IDE (IntelliJ IDEA, Eclipse) lub Maven
- System operacyjny: Windows/Linux/macOS
