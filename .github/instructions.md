## Pull Request Review Scope

### Files to review
Only review files under:
- composeApp/src/commonMain/**
- composeApp/src/androidMain/**
- composeApp/src/iosMain/**

### Files to ignore
Ignore completely:
- **/build/**
- **/.gradle/**
- **/.idea/**
- **/iosApp/**
- **/composeApp/src/commonTest/**
- **/composeApp/src/**/generated/**
- generated files
- test-only changes

### Review guidelines
- Review only code logic and correctness
- Do not assume any specific architecture
- Do not suggest architectural patterns or refactors
- Avoid comments about formatting or imports unless critical
